package com.zw;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import org.junit.Test;
import java.net.URL;
import java.nio.file.Paths;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


/**
 * swagger2 转为离线文档
 * @author：zhaowei
 * @Date：2018/12/20
 * @Time：上午9:49
 */
@EnableAutoConfiguration
public class Swagger2Markup {
    /**
     * 生成AsciiDocs格式文档,并汇总成一个文件
     *
     * @throws Exception
     */
    @Test
    public void generateAsciiDocsToFile() throws Exception {
        //    输出Ascii到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://127.0.0.1:8888/v2/api-docs?group=前端接口文档"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("../docs/asciidoc/generated/all"));
    }

    /**
     * 生成Markdown格式文档,并汇总成一个文件
     *
     * @throws Exception
     */
    @Test
    public void generateMarkdownDocsToFile() throws Exception {
        //    输出Markdown到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://127.0.0.1:8888/v2/api-docs?group=前端接口文档"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("../docs/markdown/generated/all"));
    }
}
