package site.doget.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import site.doget.common.ApiResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/api/*")
public class FrontController extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // 매핑 URL,호출될 컨트롤러
    private final Map<String, Controller> controllerMap = new LinkedHashMap<>();

    public FrontController() {
        controllerMap.put("/api/bank/info", new BankInfoController());
        controllerMap.put("/api/income", new IncomeController());
        controllerMap.put("/api/financial", new FinancialController());
        controllerMap.put("/api/loan/customers", new LoanCustomerController());
        controllerMap.put("/api/loan", new LoanInfoController());
        controllerMap.put("/api/deposit/customers", new DepositCustomerController());
        controllerMap.put("/api/deposit", new DepositInfoController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        Controller controller = findController(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        ApiResponse<?> controllerApiResponse = controller.process(requestURI, paramMap);

        response.setStatus(controllerApiResponse.getStatus());
        jsonResolver(response, controllerApiResponse.getData());
    }
    private Controller findController(String requestURI) {
        for (Map.Entry<String, Controller> entry : controllerMap.entrySet()) {
            if (requestURI.startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {

        HashMap<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }

    private void jsonResolver(HttpServletResponse response, Object model) throws IOException {

        response.setContentType("application/json;charset=utf-8");

        // 객체를 JSON 문자로 변경
        String result = objectMapper.writeValueAsString(model);
        response.getWriter().write(result);
    }

}