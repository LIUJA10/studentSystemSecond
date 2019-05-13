package cn.web.action;


import cn.pojo.TBanji;
import cn.service.TBanjiService;
import cn.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class TBanjiAction extends ActionSupport implements ModelDriven<TBanji> {
	private TBanji tBanji=new TBanji();
	private TBanjiService tBanjiService;
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(TBanji.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(tBanji.getMingcheng())){
			dc.add(Restrictions.like("mingcheng", "%"+tBanji.getMingcheng()+"%"));
		}

		//1 调用Service查询分页数据(PageBean)
		PageBean pb = tBanjiService.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	public  String add(){
		tBanjiService.save(tBanji);
		return "tolist";
	}
	public String toEdit() throws Exception {
		//1 调用Service,查询
		TBanji banji= tBanjiService.getById(tBanji.getClass_id());
		//2 将查询的对象放入request域,转发到添加页面
		ActionContext.getContext().put("tBanji", banji);
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

	public void settBanjiService(TBanjiService tBanjiService) {
		this.tBanjiService = tBanjiService;
	}

	@Override
	public TBanji getModel() {
		return tBanji;
	}
}
