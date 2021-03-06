package quick.pager.shop.feign.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class PublishCouponDTO extends ManageDTO {
    private static final long serialVersionUID = 1890447832247125669L;

    private String file;

    private Long templateId;
}
