package cn.web.action;


import cn.pojo.TChengji;
import cn.service.TChengjiService;
import cn.service.impl.TChengjiServiceImpl;
import cn.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class TChengjiAction extends ActionSupport implements ModelDriven<TChengji> {
	private TChengji tChengji=new TChengji();
	private TChengjiService tChengjiService;
	private Integer currentPage;
	private Integer pageSize;

	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(TChengji.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(tChengji.getKemu())){
			dc.add(Restrictions.like("kemu", "%"+tChengji.getKemu()+"%"));
		}

		//1 调用Service查询分页数据(PageBean)
		PageBean pb = tChengjiService.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	public  String add(){
		tChengjiService.save(tChengji);
		return "tolist";
	}
	public String toEdit() throws Exception {
		//1 调用Service,查询
		TChengji chengji=tChengjiService.getById(tChengji.getChengji_id());
		//2 将查询的对象放入request域,转发到添加页面
		ActionContext.getContext().put("tChengji", chengji);
		return "add";
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void settChengjiService(TChengjiService tChengjiService) {
		this.tChengjiService = tChengjiService;
	}

	@Override
	public TChengji getModel() {
		return tChengji;
	}
}
