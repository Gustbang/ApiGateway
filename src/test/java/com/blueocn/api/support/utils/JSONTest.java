package com.blueocn.api.support.utils;

import com.alibaba.fastjson.JSON;
import com.blueocn.api.vo.ApiVo;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JSONTest {

    @Test
    public void testSerialize() throws Exception {
        ApiVo apiVo = new ApiVo();
        apiVo.setName("name");
        apiVo.setRequestHost("host");
        apiVo.setRequestPath("path");
        apiVo.setUpstreamUrl("url");
        String json = JSON.toJSONString(apiVo);
        Assert.assertTrue(json.contains("\"name\":\"name\""));
        Assert.assertTrue(json.contains("\"request_host\":\"host\""));
        Assert.assertTrue(json.contains("\"request_path\":\"path\""));
        Assert.assertTrue(json.contains("\"upstream_url\":\"url\""));

        String testStr =
            "[{\"name\":\"name\",\"preserve_host\":false,\"request_host\":\"host\",\"request_path\":\"path\",\"strip_request_path\":false,\"upstream_url\":\"url\"},"
            + "{\"name\":\"name\",\"preserve_host\":false,\"request_host\":\"host\",\"request_path\":\"path\",\"strip_request_path\":false,\"upstream_url\":\"url\"},"
            + "{\"name\":\"name\",\"preserve_host\":false,\"request_host\":\"host\",\"request_path\":\"path\",\"strip_request_path\":false,\"upstream_url\":\"url\"}]";

        List<ApiVo> list = JSON.parseArray(testStr, ApiVo.class);
        Assert.assertEquals(list.size(), 3);
    }
}