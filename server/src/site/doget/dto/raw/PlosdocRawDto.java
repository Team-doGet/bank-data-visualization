package site.doget.dto.raw;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlosdocRawDto {

    private String baseYm;
    private int C40000000;
    private int C41000000;
    private int C42000000;
    private int C43000000;
    private int C45000000;
    private int C47000000;
    private int C48000000;
    private int C55000000;
    private int C57000000;
    private int C58000000;
    private int C60000000;
    private int C61000000;
    private int C62000000;
    private int C63000000;
    private int C65000000;
    private int C66000000;
    private int C67000000;
    private int C77000000;
    private int C78000000;

    public int getValueByCode(String code) {
        switch (code) {
            case "C40000000":
                return getC40000000();
            case "C41000000":
                return getC41000000();
            case "C42000000":
                return getC42000000();
            case "C43000000":
                return getC43000000();
            case "C45000000":
                return getC45000000();
            case "C47000000":
                return getC47000000();
            case "C48000000":
                return getC48000000();
            case "C55000000":
                return getC55000000();
            case "C57000000":
                return getC57000000();
            case "C58000000":
                return getC58000000();
            case "C60000000":
                return getC60000000();
            case "C61000000":
                return getC61000000();
            case "C62000000":
                return getC62000000();
            case "C63000000":
                return getC63000000();
            case "C65000000":
                return getC65000000();
            case "C66000000":
                return getC66000000();
            case "C67000000":
                return getC67000000();
            case "C77000000":
                return getC77000000();
            case "C78000000":
                return getC78000000();
            default:
                throw new IllegalArgumentException("유효하지 않는 code 입니다.: " + code);
        }
    }
}
