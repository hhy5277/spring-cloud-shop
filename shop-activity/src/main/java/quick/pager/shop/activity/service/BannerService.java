package quick.pager.shop.activity.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.RedisKeys;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.common.service.RedisService;
import quick.pager.shop.activity.dto.BannerDTO;
import quick.pager.shop.activity.mapper.BannerMapper;
import quick.pager.shop.model.activity.Banner;

@Service
@Slf4j
public class BannerService implements IService<List<Banner>> {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public Response<List<Banner>> doService(BaseDTO dto) {

        BannerDTO bannerDTO = (BannerDTO) dto;
        String key = RedisKeys.ActivityKeys.SHOP_BANNER_LIST;
        Response<List<Banner>> response = redisService.get(key);

        if (!ObjectUtils.isEmpty(response)) {
            return response;
        }
        response = new Response<>();
        List<Banner> banners = bannerMapper.selectBanner(null, bannerDTO.getBannerType());

        banners = banners.stream().filter(banner -> !banner.getDeleteStatus()).collect(Collectors.toList());
        response.setData(banners);

        redisService.set(key, response, 30 * 24 * 60 * 60L);

        return response;
    }
}
