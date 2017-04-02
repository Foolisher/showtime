package guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * @author wanggen
 */
public class FlightServletContextListener extends GuiceServletContextListener {
  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new ServletModule() {

      @Override
      protected void configureServlets() {
        install(new MainModule());                     //(1).安装初始化我们的业务模块
        serve("/").with(IndexServlet.class);           //(2).url mapping 首页
        serve("/user.*").with(UserServlet.class);      //(3).url mapping 用户相关

      }
    });
  }
}