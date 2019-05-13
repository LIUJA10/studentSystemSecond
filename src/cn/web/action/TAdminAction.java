package cn.web.action;
import javax.servlet.http.HttpServletRequest;

import cn.service.TAdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import cn.pojo.TAdmin;

import com.opensymphony.xwork2.ActionSupport;

public class TAdminAction extends ActionSupport implements ModelDriven<TAdmin> {
	private TAdmin tAdmin=new TAdmin();
	private TAdminService tAdminService;

	public void settAdminService(TAdminService tAdminService) {
		this.tAdminService = tAdminService;
	}

	public String login() throws Exception{
		TAdmin a=tAdminService.getUserByCodePassword(tAdmin);
		ActionContext.getContext().getSession().put("tAdmin",a);

		return "toHome";
    }

	@Override
	public TAdmin getModel() {
		return tAdmin;
	}
}
