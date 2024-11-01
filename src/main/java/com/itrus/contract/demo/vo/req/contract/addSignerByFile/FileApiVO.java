package com.itrus.contract.demo.vo.req.contract.addSignerByFile;

import com.itrus.contract.demo.vo.req.template.create.WaterMarkBaseVO;
import lombok.Data;

import java.util.List;

/**
 * @author pjw
 */
@Data
public class FileApiVO {

    /**
     * 合同文档名称1-64字符，支持中文、英文大小写，数字、特殊字符
     */
    private String docName;

    /**
     * 合同文件base64，最大不超过5MB，支持pdf/doc/docx/ofd文件格式
     */
    private String base64;

    /**
     * 文件绝对路径（带文件名）(base64与filePath二选一必填)
     */
    private String filePath;

    /**
     * 文件绝对路径类型:1ftp路径(默认)、2http路径
     */
    private Integer pathType;

    /**
     * 是否开启水印(0:不开启;1:开启)
     */
    private Boolean waterMarkOff;

    /**
     * 水印集合设置参数
     */
    private List<WaterMarkBaseVO> waterMarkParams;

}
