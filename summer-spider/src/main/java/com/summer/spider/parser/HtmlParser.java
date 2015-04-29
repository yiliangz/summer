package com.summer.spider.parser;

import com.summer.common.constant.EncodingConstant;
import com.summer.common.utils.DateUtils;
import com.summer.common.utils.HttpUrlContextUtils;
import com.summer.common.utils.RegexUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Allen on 2015/4/17.
 */
public abstract class HtmlParser implements DataParser {

    Element content;

    public HtmlParser(){

    };

    public HtmlParser init(Element content) {
        this.content = content;
        return this;
    }

    public HtmlParser init(String html) {
        this.content = Jsoup.parse(html);
        return this;
    }

    public HtmlParser init(String html, String selector) {
        this.content = Jsoup.parse(html).select(selector).first();
        return this;
    }


    /**
     * 按encoding参数的格式从url中读取
     * */
    public HtmlParser load(String url, String encoding) {
        this.content = Jsoup.parse(HttpUrlContextUtils.getResponseText(url,null,encoding));
        return this;
    }

    /**
     * 按gb2312的encoding的格式从url中读取
     * */
    public HtmlParser loadByGbEncoding(String url) {
        return load(url, EncodingConstant.GB_ENCODING);
    }

    public Element getContent() {
        return this.content;
    }

    public void parse() {

    }

    @Override
    public Long getLong(String data) {
        return Long.valueOf(RegexUtils.getNumericData(data));
    }

    @Override
    public Double getDouble(String data) {
        return Double.valueOf(RegexUtils.getNumericData(data));
    }

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
