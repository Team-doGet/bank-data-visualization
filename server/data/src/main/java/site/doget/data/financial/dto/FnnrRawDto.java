package site.doget.data.financial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FnnrRawDto {
    private String baseYm;
    private int C10000000;
    private int C11000000;
    private int C14000000;
    private int C15000000;
    private int C16000000;
    private int C17000000;
    private int C19000000;
    private int C20000000;
    private int C21000000;
    private int C22000000;
    private int C23000000;
    private int C30000000;
    private int C31000000;
    private int C32000000;
    private int C33000000;
    private int C34000000;
    private int C35000000;
    private int C39000000;

    public int getValueByCode(String code) {
        switch (code) {
            case "C10000000":
                return getC10000000();
            case "C11000000":
                return getC11000000();
            case "C14000000":
                return getC14000000();
            case "C15000000":
                return getC15000000();
            case "C16000000":
                return getC16000000();
            case "C17000000":
                return getC17000000();
            case "C19000000":
                return getC19000000();
            case "C20000000":
                return getC20000000();
            case "C21000000":
                return getC21000000();
            case "C22000000":
                return getC22000000();
            case "C23000000":
                return getC23000000();
            case "C30000000":
                return getC30000000();
            case "C31000000":
                return getC31000000();
            case "C32000000":
                return getC32000000();
            case "C33000000":
                return getC33000000();
            case "C34000000":
                return getC34000000();
            case "C35000000":
                return getC35000000();
            case "C39000000":
                return getC39000000();
            default:
                throw new IllegalArgumentException("유효하지 않는 code 입니다.: " + code);
        }
    }
}