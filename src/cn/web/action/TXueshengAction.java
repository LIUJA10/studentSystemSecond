package cn.web.action;


import javax.servlet.http.HttpServletRequest;

import cn.service.TXueshengService;
import cn.utils.PageBean;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.pojo.TXuesheng;
import cn.service.impl.TXueshengServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class TXueshengAction extends ActionSupport implements ModelDriven<TXuesheng> {
	private TXuesheng tXuesheng=new TXuesheng();
	private Integer currentPage;
	private Integer pageSize;
	private TXueshengService tXueshengService;

	public void settXueshengService(TXueshengService tXueshengService) {
		this.tXueshengService = tXueshengService;
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
	public String login() throws Exception{
		TXuesheng t=tXueshengService.getStudentByCodePassword(tXuesheng);
		ActionContext.getContext().getSession().put("tXuesheng",t);
		return "toHome";


    }
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(TXuesheng.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(tXuesheng.getUserName())){
			dc.add(Restrictions.like("userName", "%"+tXuesheng.getUserName()+"%"));
		}

		//1 调用Service查询分页数据(PageBean)
		PageBean pb = tXueshengService.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	public  String add(){
		tXueshengService.save(tXuesheng);
		return "tolist";
	}
	public String toEdit() throws Exception {
		//1 调用Service,查询
		TXuesheng t=tXueshengService.getById(tXuesheng.getXs_id());
		//2 将查询的对象放入request域,转发到添加页面
		ActionContext.getContext().put("tXuesheng", t);
		return "add";
	}

	@Override
	public TXuesheng getModel() {
		return tXuesheng;
	}
}
