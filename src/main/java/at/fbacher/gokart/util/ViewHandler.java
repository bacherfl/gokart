package at.fbacher.gokart.util;

import javax.faces.application.ViewHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.mobile.renderkit.MobileRenderKit;

public class ViewHandler extends ViewHandlerWrapper {

	private javax.faces.application.ViewHandler wrapped;
	
	public ViewHandler(javax.faces.application.ViewHandler wrapped) {
		this.wrapped = wrapped;
	}
	
	@Override
	public javax.faces.application.ViewHandler getWrapped() {
		return wrapped;
	}
	
	@Override
	public String calculateRenderKitId(FacesContext context) {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String pathInfo = request.getRequestURI();
		if (pathInfo.contains("/admin")) {
			return this.wrapped.calculateRenderKitId(context);
		}
		return MobileRenderKit.RENDER_KIT_ID;
	}

}
