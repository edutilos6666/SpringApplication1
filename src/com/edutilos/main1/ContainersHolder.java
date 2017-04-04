package com.edutilos.main1;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ContainersHolder {
   private List<String> list ;
    private Set<String> set;
    private Map<Long , String> map;
    private Properties props ;

    public ContainersHolder(List<String> list, Set<String> set, Map<Long, String> map, Properties props) {
        this.list = list;
        this.set = set;
        this.map = map;
        this.props = props;
    }

    public ContainersHolder() {
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<Long, String> getMap() {
        return map;
    }

    public void setMap(Map<Long, String> map) {
        this.map = map;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "ContainersHolder{" +
                "list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", props=" + props +
                '}';
    }
}
