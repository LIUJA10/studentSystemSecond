package cn.web.action;


import cn.pojo.TKoufen;
import cn.service.TKoufenService;
import cn.service.impl.TKoufenServiceImpl;
import cn.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class TKoufenAction extends ActionSupport implements ModelDriven<TKoufen> {
	private TKoufen tKoufen=new TKoufen();
	private TKoufenService tKoufenService;
	private Integer currentPage;
	private Integer pageSize;

	public void settKoufenService(TKoufenService tKoufenService) {
		this.tKoufenService = tKoufenService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public TKoufen getModel() {
		return tKoufen;
	}

	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(TKoufen.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(tKoufen.getXiangmu())){
			dc.add(Restrictions.like("xiangmu", "%"+tKoufen.getXiangmu()+"%"));
		}

		//1 调用Service查询分页数据(PageBean)
		PageBean pb = tKoufenService.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	public  String add(){
		tKoufenService.save(tKoufen);
		return "tolist";
	}
	public String toEdit() throws Exception {
		//1 调用Service,查询
		TKoufen koufen= tKoufenService.getById(tKoufen.getkoufen_id());
		//2 将查询的对象放入request域,转发到添加页面
		ActionContext.getContext().put("tKoufen", koufen);
		return "add";
	}

}
