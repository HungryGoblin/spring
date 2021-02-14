import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;


@WebServlet(name = "webapp", urlPatterns = "/web_app")
public class Servlet implements javax.servlet.Servlet {

    private ArrayList<Product> productList = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(Servlet.class);

    private ServletConfig servletConfig;

    public void setProductList() {
        productList.add(new Product(0, "iPone 4", BigDecimal.valueOf(100.10)));
        productList.add(new Product(1, "iPone 5", BigDecimal.valueOf(120.50)));
        productList.add(new Product(2, "iPone 6", BigDecimal.valueOf(160.35)));
        productList.add(new Product(3, "iPone 7", BigDecimal.valueOf(190.20)));
        productList.add(new Product(4, "iPone 8", BigDecimal.valueOf(220.90)));
        productList.add(new Product(5, "iPone 9", BigDecimal.valueOf(299.99)));
        productList.add(new Product(6, "iPone X", BigDecimal.valueOf(399.99)));
        productList.add(new Product(7, "iPone 11", BigDecimal.valueOf(499.99)));
        productList.add(new Product(8, "iPone 12", BigDecimal.valueOf(499.99)));
        productList.add(new Product(8, "iPone 13", BigDecimal.valueOf(699.99)));
        productList.add(new Product(9, "iPone 14", BigDecimal.valueOf(999.99)));
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        setProductList();
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        LOGGER.info("New request");
        for (int i = 0; i < productList.size(); i++)
            servletResponse.getWriter().printf("<h1>%s</h1>", productList.get(i));
    }

    @Override
    public String getServletInfo() {
        return "ServletInfo";
    }

    @Override
    public void destroy() {
        LOGGER.info("Servlet {} destroyed", getServletInfo());
    }
}
