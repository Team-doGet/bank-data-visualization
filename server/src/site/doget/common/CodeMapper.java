package site.doget.common;

import java.util.HashMap;
import java.util.Map;

public class CodeMapper {

    public static final Map<String, String> incomeMap = new HashMap<>();
    public static final Map<String, String> financialMap = new HashMap<>();

    static {

        /**
         * income
         */
        incomeMap.put("C40000000", "비용합계");
        incomeMap.put("C41000000", "이자비용");
        incomeMap.put("C42000000", "유가증권관련비용");
        incomeMap.put("C43000000", "수수료비용");
        incomeMap.put("C45000000", "기타비용");
        incomeMap.put("C47000000", "판매비와관리비");
        incomeMap.put("C48000000", "대출채권관련손실");
        incomeMap.put("C55000000", "법인세비용");
        incomeMap.put("C57000000", "손실합계");
        incomeMap.put("C58000000", "당기이익");
        incomeMap.put("C60000000", "수익합계");
        incomeMap.put("C61000000", "이자수익");
        incomeMap.put("C62000000", "유가증권관련수익");
        incomeMap.put("C63000000", "수수료수익");
        incomeMap.put("C65000000", "기타수익");
        incomeMap.put("C66000000", "대출채권관련수익");
        incomeMap.put("C67000000", "배당금수익");
        incomeMap.put("C77000000", "이익합계");
        incomeMap.put("C78000000", "당기손실");

        /**
         * financial
         */
    }
}
