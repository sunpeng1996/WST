  	// 手机号码验证
jQuery.validator.addMethod("mobile", function(value, element) {
    var length = value.length;
//    var mobile =  /^1[3|4|5|8][0-9]\d{8}$/
    var mobile =  /(^1[3|4|5|7|8][0-9]{9}$)/
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确输入您的手机号码");
//IP地址验证
jQuery.validator.addMethod("ip", function(value, element) {
    var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
    return this.optional(element) || (ip.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
}, "Ip地址格式错误");
//字母和数字的验证
jQuery.validator.addMethod("chrnum", function(value, element) {
    var chrnum = /^([a-zA-Z0-9]+)$/;
    return this.optional(element) || (chrnum.test(value));
}, "只能输入数字和字母(字符A-Z, a-z, 0-9)");

// 中文的验证
jQuery.validator.addMethod("chinese", function(value, element) {
    var chinese = /^[\u4e00-\u9fa5]+$/;
    return this.optional(element) || (chinese.test(value));
}, "只能输入中文");

// 下拉框验证
$.validator.addMethod("selectNone", function(value, element) {
    return value == "请选择";
}, "必须选择一项");

//身份证号码验证 
jQuery.validator.addMethod("isIdCardNo", function(value, element) {
  var isIdCardNo =/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
  return this.optional(element) || (isIdCardNo.test(value));     
}, "请正确输入您的身份证号码"); 

//邮箱验证
jQuery.validator.addMethod("email", function(value, element) {
  var email = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$/;
  return this.optional(element) || (email.test(value));     
}, "请输入有效的邮箱"); 

//只能输入数字
jQuery.validator.addMethod("number", function(value, element) {
  var number = /^[0-9]*$/;
  return this.optional(element) || (number.test(value));     
}, "请输入有效的数字"); 

//符号只允许"_",其它都允许
jQuery.validator.addMethod("contain", function(value, element) {
  var contain =/^[a-zA-Z0-9_]{6,11}$/;
  return this.optional(element) || (contain.test(value));     
}, "输入格式错误"); 

/**
 * 年份验证
 * @author 林乐超
 * @date 2015年9月12日 下午3:08:02
 */
jQuery.validator.addMethod("year", function(value, element) {
  var contain =/^(?:19|20)[0-9][0-9]$/;
  return this.optional(element) || (contain.test(value));     
}, "输入正确年份格式"); 


/**
 * 月份验证
 * @author 林乐超
 * @date 2015年9月12日 下午3:08:02
 */
jQuery.validator.addMethod("month", function(value, element) {
  var contain =/^(0?[[1-9]|1[0-2])$/;
  return this.optional(element) || (contain.test(value));     
}, "输入正确月份格式"); 

/**
 * 日验证
 * @author 林乐超
 * @date 2015年12月01日 下午3:08:02
 */
jQuery.validator.addMethod("day", function(value, element) {
  var contain =/^(0?[1-9]|[1-2]\d|3[0-1])$/;
  return this.optional(element) || (contain.test(value));     
}, "输入正确月份格式11"); 

/**
 * 数字 小数验证
 * @author 林乐超
 * @date 2015年12月01日 下午3:08:02
 */
jQuery.validator.addMethod("doubleNum", function(value, element) {
  var contain =/^[0-9]+(.[0-9]{1,3})?$/;
  return this.optional(element) || (contain.test(value));     
}, "输入正确带3位小数的数字格式"); 


/**
 * 真实姓名
 */
jQuery.validator.addMethod("real", function(value, element) {
  var real =/^[\u4e00-\u9fa5]{2,4}|[a-zA-Z]{2,10}$/g;
  return this.optional(element) || (real.test(value));     
}, "请输入正确得姓名"); 


/**
 * 汉字验证
 */
jQuery.validator.addMethod("realName", function(value, element) {
  var realName =/^[\u4e00-\u9fa5]{2,4}$/;;
  return this.optional(element) || (realName.test(value));     
}, "请输入正确得姓名"); 
