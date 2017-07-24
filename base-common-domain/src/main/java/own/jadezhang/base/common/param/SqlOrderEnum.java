package own.jadezhang.base.common.param;

/**
 * Created by Zhang Junwei on 2017/7/24.
 */
public enum  SqlOrderEnum {

    DESC("DESC","降序"),

    ASC("ASC", "升序");

    private String action;
    private String name;

    private SqlOrderEnum(String action, String name) {
        this.action = action;
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
