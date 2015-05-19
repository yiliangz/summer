package com.summer.spider.parser;

import com.summer.common.constant.EncodingConstant;
import com.summer.common.utils.DateUtils;
import com.summer.common.utils.HttpUrlContextUtils;
import com.summer.common.utils.RegexUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Allen on 2015/4/17.
 */
public abstract class HtmlParser implements DataParser {

    /**
     * jsoup的Element类型,相当jquery的jquery对象
     */
    Element content;

    public HtmlParser() {

    }

    public HtmlParser init(Element content) {
        this.content = content;
        return this;
    }

    /**
     * 解析html的内容以初始化content
     *
     * @param html html内容
     * @return HtmlParser
     */
    public HtmlParser init(String html) {
        this.content = Jsoup.parse(html);
        return this;
    }


    /**
     * 把html的内容用selector解析出来
     *
     * @param html     html内容
     * @param selector encoding编码
     * @return HtmlParser
     */
    public HtmlParser init(String html, String selector) {
        this.content = Jsoup.parse(html).select(selector).first();
        return this;
    }

    public boolean isInitSuccess() {
        return this.content != null;
    }

    /**
     * 按encoding参数的格式从url中读取
     *
     * @param url      http url
     * @param encoding encoding编码
     * @return HtmlParser
     */
    public HtmlParser load(String url, String encoding) {
        String html = HttpUrlContextUtils.getResponseText(url, null, encoding);
        if (!StringUtils.isEmpty(html)) {
            this.content = Jsoup.parse(html);
        } else {
            this.content = null;
        }
        return this;
    }

    /**
     * 按gb2312的encoding的格式从url中读取
     *
     * @param url http url
     * @return HtmlParser
     */
    public HtmlParser loadByGbEncoding(String url) {
        return load(url, EncodingConstant.GB_ENCODING);
    }

    public HtmlParser selectSingle(String selector) {
        this.setContent(getContent().select(selector).first());
        return this;
    }

    public Elements select(String selector) {
        return getContent().select(selector);
    }

    public Element getContent() {
        return this.content;
    }

    public void setContent(Element content) {
        this.content = content;
    }

    public void parse() {

    }

    /**
     * 获取Long类型的数据
     *
     * @param data String格式的数据
     * @return Long
     */
    @Override
    public Long getLong(String data) {
        return Long.valueOf(RegexUtils.getNumericData(data));
    }

    /**
     * 获取Double类型的数据
     *
     * @param data String格式的数据
     * @return Double
     */
    @Override
    public Double getDouble(String data) {
        return Double.valueOf(RegexUtils.getNumericData(data));
    }

    /**
     * 获取Date类型的数据
     *
     * @param data String格式的数据
     * @return Date
     */
    @Override
    public Date getDate(String data) {
        try {
            return DateUtils.parseNoZeroDate(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
