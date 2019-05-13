package cn.web.action;


import cn.pojo.TJiafen;
import cn.service.TJiafenService;
import cn.service.impl.TJiafenServiceImpl;
import cn.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class TJiafenAction extends ActionSupport  implements ModelDriven<TJiafen> {
	private TJiafen tJiafen=new TJiafen();
	private TJiafenService tJiafenService;
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(TJiafen.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(tJiafen.getXiangmu())){
			dc.add(Restrictions.like("xiangmu", "%"+tJiafen.getXiangmu()+"%"));
		}

		//1 调用Service查询分页数据(PageBean)
		PageBean pb = tJiafenService.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	public  String add(){
		tJiafenService.save(tJiafen);
		return "tolist";
	}
	public String toEdit() throws Exception {
		//1 调用Service,查询
		TJiafen jiafen= tJiafenService.getById(tJiafen.getjiafen_id());
		//2 将查询的对象放入request域,转发到添加页面
		ActionContext.getContext().put("tJiafen", jiafen);
		return "add";
	}


	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void settJiafenService(TJiafenService tJiafenService) {
		this.tJiafenService = tJiafenService;
	}

	@Override
	public TJiafen getModel() {
		return tJiafen;
	}
}
