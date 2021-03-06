package quick.pager.shop.feign.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class CouponDTO extends ManageDTO {
    private static final long serialVersionUID = 7596667898732568306L;

    private String couponName;

    private String phone;

    private Integer discountType;

}
