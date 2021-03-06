package com.kfzx.util;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class HtmlUtil {

	public static void main(String[] args) {

	}

	public static void update_html_del_img(String origin_html, String this_html, String webPath) {

		//这里判断下this_html有可能是空
		if(StringUtil.isEmpty(this_html)){
			this_html="";
		}

		// 对比图片。看看是不是要删除一些图片
		Document doc = Jsoup.parse(origin_html);
		Elements origin_blog_img_list = doc.select("img");
		doc = Jsoup.parse(this_html);
		Elements this_blog_img_list = doc.select("img");
		// 开始对比 图片列表
		// 过虑一边 原图片集 现图片集 有的不动 没有删除掉

		Element img = null;
		String origin_img_src = "";
		String this_img_src = "";

		boolean delete_flag = true;

		for (int i = 0; i < origin_blog_img_list.size(); i++) {
			img = origin_blog_img_list.get(i);
			origin_img_src = img.attr("src");
			for (int j = 0; j < this_blog_img_list.size(); j++) {
				img = this_blog_img_list.get(j);
				this_img_src = img.attr("src");
				if (origin_img_src.equals(this_img_src)) {
					delete_flag = false;
					continue;
				}
			}

			if (delete_flag) {
				FileUtil.deleteFile(webPath + origin_img_src);
			}
			delete_flag = true;
		}
	}



	/**
	 * 这个方法 ，如果文章删除了，这个方法就执行。
	 *
	 * @param
	 * @param webPath
	 */
	public static void delete_html_all_img(String htmlContent, String webPath) {
		Document doc = Jsoup.parse(htmlContent);
		Elements img_list = doc.select("img");

		for (int i = 0; i < img_list.size(); i++) {
			Element img = img_list.get(i);
			/**
			 *
			 * <img src=
			 * "/static/ueditor_upload/userImages/20170826/1503734482236009747.png"
			 * title="1503734482236009747.png" alt="blob.png"> /static/
			 * ueditor_upload/userImages/20170826/1503734482236009747.png
			 * <img src="http://img.baidu.com/hi/jx2/j_0044.gif"> http://img.
			 * baidu.com/hi/jx2/j_0044.gif
			 * <img src="http://img.baidu.com/hi/jx2/j_0054.gif"> http://img.
			 * baidu.com/hi/jx2/j_0054.gif <img src=
			 * "/static/ueditor_upload/userImages/20170826/1503734490131061897.jpg"
			 * title="1503734490131061897.jpg" alt="timg.jpg"> /static/
			 * ueditor_upload/userImages/20170826/1503734490131061897.jpg
			 */
			System.out.println(webPath+img.attr("src"));
			// 删除 = 项目路径+图片src
			FileUtil.deleteFile(webPath + img.attr("src"));
		}
		/*
		 * //删除掉缩略图 if(article.getShowImg()!=null){
		 * FileUtil.deleteFile(webPath+article.getShowImg()); }
		 */
	}


	/**
	 * 接受html内容  输出  所有的图片
	 */
	public static List<String> getImgList(String htmlContent){
		List<String> imgList = new ArrayList<String>();
		Document doc = Jsoup.parse(htmlContent);
		Elements img_list = doc.select("img");
		Element img_element = null;
		String img_src ="";
		for (Element anImg_list : img_list) {
			img_element = anImg_list;
			img_src = img_element.attr("src");
			imgList.add(img_src);
		}
		return imgList;
	}

}
