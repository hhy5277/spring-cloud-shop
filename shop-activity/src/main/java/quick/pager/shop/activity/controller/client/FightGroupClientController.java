package quick.pager.shop.activity.controller.client;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.activity.service.client.FightGroupClientService;
import quick.pager.shop.feign.dto.FightGroupDTO;

/**
 * 对外暴露的feign
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
public class FightGroupClientController {

    @Autowired
    private FightGroupClientService fightGroupClientService;

    @ApiOperation("拼团活动列表")
    @RequestMapping(value = "/fightGroup/list", method = RequestMethod.POST)
    public Response fightGroup(@RequestBody FightGroupDTO request) {
        return fightGroupClientService.fightGroup(request.getActivityName(), request.getBeginTime(), request.getEndTime(), request.getPage(), request.getPageSize());
    }

    @ApiOperation("新增修改")
    @RequestMapping(value = "/fight/modify", method = RequestMethod.POST)
    public Response modify(@RequestBody FightGroupDTO request) {
        return fightGroupClientService.modify(request);
    }

    @ApiOperation("规则详情")
    @RequestMapping("/fightGroup/rule/{groupId}")
    public Response rule(@PathVariable("groupId") Long groupId) {
        return fightGroupClientService.queryFightGroupRuleInfo(groupId);
    }

    @ApiOperation("拼团活动规则新增修改")
    @RequestMapping(value = "/fightGroup/rule/modify", method = RequestMethod.POST)
    public Response modifyRule(@RequestBody FightGroupDTO request) {
        return fightGroupClientService.rule(request);
    }


    @RequestMapping(value = "/fightGroup/goods/{groupId}", method = RequestMethod.POST)
    public Response goodsInfo(@PathVariable("groupId") Long groupId) {
        return fightGroupClientService.goodsInfo(groupId);
    }

    @ApiOperation("拼团规则的商品新增修改")
    @RequestMapping(value = "/fightGroup/goods/modify", method = RequestMethod.POST)
    public Response goodsModify(@RequestBody FightGroupDTO request) {
        return fightGroupClientService.goodsModify(request);
    }

    @ApiOperation("成团记录")
    @RequestMapping(value = "/fightGroup/records", method = RequestMethod.POST)
    public Response records(@RequestBody FightGroupDTO request) {
        return fightGroupClientService.records(request.getId(), request.getBeginTime(), request.getEndTime(), request.getPage(), request.getPageSize());
    }

    @ApiOperation("参与成团人员")
    @RequestMapping(value = "/fightGroup/members", method = RequestMethod.POST)
    public Response members(@RequestParam("recordId") Long recordId, @RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        return fightGroupClientService.members(recordId, page, pageSize);
    }
}
