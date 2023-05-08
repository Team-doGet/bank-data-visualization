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
        financialMap.put("C10000000", "자산");
        financialMap.put("C11000000", "현금및예치금");
        financialMap.put("C14000000", "대출채권");
        financialMap.put("C15000000", "고정자산");
        financialMap.put("C16000000", "기타자산");
        financialMap.put("C17000000", "유가증권");
        financialMap.put("C19000000", "손실금");
        financialMap.put("C20000000", "부채");
        financialMap.put("C21000000", "예수부채");
        financialMap.put("C22000000", "차입부채");
        financialMap.put("C23000000", "기타부채");
        financialMap.put("C30000000", "자본");
        financialMap.put("C31000000", "자본금");
        financialMap.put("C32000000", "자본잉여금");
        financialMap.put("C33000000", "이익잉여금");
        financialMap.put("C34000000", "자본조정");
        financialMap.put("C35000000", "기타포괄손익누계액");
        financialMap.put("C39000000", "이익금");
    }
}
