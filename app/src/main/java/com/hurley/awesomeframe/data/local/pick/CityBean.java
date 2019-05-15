package com.hurley.awesomeframe.data.local.pick;

import com.contrarywind.interfaces.IPickerViewData;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-11 15:53
 *      github  : https://github.com/HurleyJames
 *      desc    : 城市选择器数据实体类
 * </pre>
 */
public class CityBean implements IPickerViewData {

    private long id;
    private String name;
    private String desc;
    private String others;

    public CityBean(long id, String name, String desc, String others) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.others = others;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String getPickerViewText() {
        return name;
    }
}
