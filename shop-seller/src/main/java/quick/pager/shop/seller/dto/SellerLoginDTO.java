package quick.pager.shop.seller.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.feign.dto.UserInfoDTO;

/**
 * 登陆
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SellerLoginDTO extends UserInfoDTO {
    private static final long serialVersionUID = -8483169592580367377L;

    /**
     * 登陆密码
     */
    private String password;

}
