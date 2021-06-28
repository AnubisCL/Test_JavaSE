package cn.test.exer2;

import java.util.*;

public class Dao<T> {
    private Map<String , T> map = new HashMap<String , T>();

    /**
     * 保存 T 类型的对象到 Map 成员变量中
     * @param id
     * @param entity
     */
    public void save(String id,T entity){
        this.map.put(id, entity);
    }

    /**
     * 从 map 中获取 id 对应的对象
     * @param id
     * @return
     */
    public T get(String id){
        T value = this.map.get(id);
        return value;
    }

    /**
     * 替换 map 中 key 为 id 的内容,改为 entity 对象
     * @param id
     * @param entity
     */
    public void update(String id,T entity) {
        if (map.containsKey(id)){
            this.map.put(id,entity);
        }
    }

    /**
     * 返回 map 中存放的所有 T 对象
     * @return
     */
    public List<T> list() {
        //错误的：
        //List<T> values = (List<T>) this.map.values();
        //return values;
        //正确的：
        Collection<T> values = this.map.values();
        ArrayList<T> list = new ArrayList<>();
        for (T t : values) {
            list.add(t);
        }
        return list;
    }

    /**
     * 删除指定 id 对象
     * @param id
     */
    public void delete(String id) {
        this.map.remove(id);
    }
}
