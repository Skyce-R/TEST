package com.itrus.contract.demo.utils.log;

import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author pjw
 * @date 2021/6/1/0001
 */
public class ParamFilter implements ValueFilter {

    private Set<String> filterSet = new HashSet<>(Arrays.asList("imageBase64", "doc","doc2","base64","contractFile","templateFile","sealBase64","autographBase64","codeContent","videoFile","personSign","pdfBytes","value1","fileBytes","file","watermarkFileBase64"));

    public ParamFilter(){
    }

    public ParamFilter(Set<String> filterSet){
        this.filterSet = filterSet;
    }
    @Override
    public Object process(Object o, String key, Object value) {
        //1.根据key过滤
        if(null != filterSet && filterSet.size() > 0) {
            for (Iterator<String> it = filterSet.iterator(); it.hasNext(); ) {
                if (key.equals(it.next())) {
                    return "base64:***";
                }
            }
        }

        //2.根据值包含的字符过滤
        if(value instanceof String){
            String val = value.toString();
            if(val.contains("base64:")){
                return "base64:***";
            }
        }
        return value;
    }

}
