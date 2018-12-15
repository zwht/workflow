package com.zw;

import org.junit.Test;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：zhaowei
 * Date：2018/12/15
 * Time：下午8:18
 * 魏翼超然：http://120.79.171.251:9876
 * ========================
 */
public class SpringbootSwaggerApplicationTests {
    private String snippetDir = "/generated/snippets";
    private String outputDir = "generated/swagger-ui";

    @Test
    public void doIt() throws Exception{
        // 读取上一步生成的swagger.json转成asciiDoc,写入到outputDir
//        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
//                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
//                .withMarkupLanguage(MarkupLanguage.MARKDOWN)// 格式
//                .withExamples(snippetDir)
//                .build()
//                .intoFolder(outputDir);// 输出
    }


}
