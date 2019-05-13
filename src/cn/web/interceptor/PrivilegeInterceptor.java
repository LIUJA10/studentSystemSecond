package cn.web.interceptor;

import java.util.Map;

import cn.pojo.TAdmin;
import cn.pojo.TXuesheng;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	//不校验登陆和注册方法
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1 获得Session
			Map<String, Object> session = ActionContext.getContext().getSession();
		//2 获得登陆标识
			TAdmin tAdmin=(TAdmin) session.get("tAdmin");
			TXuesheng tXuesheng=(TXuesheng) session.get("tXuesheng");
		//3 判断标识是否存在
			if(tAdmin != null && tXuesheng !=null){
				//存在=> 放行
				return invocation.invoke();
			}else{
				//不存在=> 重定向到登陆页面
				return "toLogin";
			}
			
	}

}
