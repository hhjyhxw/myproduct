package zhumeng.com.uimei.web.wxserver.entity.wexinmsg;

public class PicMsg extends BaseMessage {
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
	/*private static XStream xstream = new XStream(new XppDriver() {  
	    public HierarchicalStreamWriter createWriter(Writer out) {  
	        return new PrettyPrintWriter(out) {  
	            // ������xml�ڵ��ת��������CDATA���   
	            boolean cdata = true;  
  
	            @SuppressWarnings("unchecked")  
	            public void startNode(String name, Class clazz) {  
		                super.startNode(name);  
            }  
	 
	            protected void writeText(QuickWriter writer, String text) {  
	               if (cdata) {  
                        writer.write("<![CDATA[");  
	                    writer.write(text);  
	                    writer.write("]]>");  
               } else {  
	                    writer.write(text);  
                }  
		            }  
	        };  
	    }  
		});  
	
public static void main(String[] args) {
	PicMsg picmsg = new PicMsg();
	Image img = new Image();
	img.setMediaId("1111111");
	picmsg.setImage(img);
	picmsg.setFromUserName("2");
	picmsg.setToUserName("s");
	picmsg.setCreateTime(System.currentTimeMillis());
	picmsg.setMsgType("78");
//	XStream xs = new XStream();
	xstream.alias("xml",PicMsg.class);
	System.out.println(xstream.toXML(picmsg));*/
	
}

