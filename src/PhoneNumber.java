// Tyler Lindley 200382154
public class PhoneNumber {
    private String areaCode, cityCode, lineNumber;

    public PhoneNumber(String areaCode, String cityCode, String lineNumber) {
        setAreaCode(areaCode);
        setCityCode(cityCode);
        setLineNumber(lineNumber);
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        if(areaCode.matches("\\(?[2-9]\\d{2}")) {
            this.areaCode = areaCode;
        }
        else {
            throw new IllegalArgumentException("Area code must be 3 digits, the first digit must be 2-9, digits 2 and three can be any valid number");
        }
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        if(cityCode.matches("\\(?[2-9]\\d{2}")) {
            this.cityCode = cityCode;
        }
        else {
            throw new IllegalArgumentException("City code must be 3 digits, the first digit must be 2-9, digits 2 and three can be any valid number");
        }
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        if (lineNumber.matches("d{4}")) {
            this.lineNumber = lineNumber;
        } else {
            throw new IllegalArgumentException("Line number must be 4 digits.");
        }
    }

    public String toString()
        { return String.format("Phone number is: %s-%s %s",
                    areaCode, cityCode, lineNumber);
        }
}
