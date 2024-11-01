package com.itrus.contract.demo.vo.req.callback;

//import com.itrus.contract.constant.callback.CallbackConstants;
import lombok.Getter;
import lombok.Setter;

//import javax.validation.constraints.NotBlank;

/**
 * @author pjw
 * @date 2022/10/6/0006
 */
@Getter
@Setter
public class CallBackApiRequest{
    /**
//     * @see com.itrus.contract.enumeration.callback.InformationChangedTypeEnum
     */
//    @NotBlank(message = CallbackConstants.CALLBACK_OPERATIONTYPE_IS_NOT_NULL)
    private String operationType;

    private String oldData;

    private String newData;

    private String serviceCode;
    private String appId;

    private Long ts;

}
