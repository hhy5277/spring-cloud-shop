package quick.pager.shop.auth.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemConfigDTO extends ManageDTO {
    private static final long serialVersionUID = -5469712897215941464L;


    private String configName;

    private String configValue;

    private String module;

    private String description;

}
