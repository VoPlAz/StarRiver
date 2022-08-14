package cc.windstream;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.BotInvitedJoinGroupRequestEvent;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.NewFriendRequestEvent;
import net.mamoe.mirai.message.data.Face;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.PlainText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public final class StarRiver extends JavaPlugin {
    public static final StarRiver INSTANCE = new StarRiver();

    private StarRiver() {
        super(new JvmPluginDescriptionBuilder("cc.windstream.StarRiver", "1.0.0")
                .name("StarRiver")
                .author("WindStream")
                .build());
    }

    @Override
    public void onEnable()
    {
        getLogger().info("Plugin loaded!");
        long startTime = System.currentTimeMillis();
        GlobalEventChannel.INSTANCE.subscribeAlways(NewFriendRequestEvent.class,FriendAuto->{
            FriendAuto.accept();
        });
        GlobalEventChannel.INSTANCE.subscribeAlways(BotInvitedJoinGroupRequestEvent.class,GroupAuto->{
            GroupAuto.accept();
        });
       GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class,ListenGroup->{
           String GroupMessageString=ListenGroup.getMessage().contentToString();
           if(GroupMessageString.equals("菜单")){
               ListenGroup.getSubject().sendMessage("            \uD83C\uDF88菜单\uD83C\uDF88            \n⚡娱乐菜单 关于作者⚡\n⚡运行状态 敬请期待⚡\n ⚡----------------------------⚡\n\uD83C\uDF89StarRiver群管系统\uD83C\uDF89");
           } else if (GroupMessageString.equals("娱乐菜单")) {
               ListenGroup.getSubject().sendMessage("          \uD83C\uDF88娱乐菜单\uD83C\uDF88          \n⚡随机动漫 随机美女⚡\n\uD83C\uDF89StarRiver群管系统\uD83C\uDF89");
           } else if (GroupMessageString.equals("关于作者")) {
               ListenGroup.getSubject().sendMessage("⚡作者:WindStream\n⚡QQ:1514037660\n⚡GitHub:github.com/VoPlAz\n⚡WebSite:windstream.liangzai45.com\n⚡Organize:StreamLgiht\n⚡机器人框架:Mirai\n⚡开发语言:Java(Mirai官方原生JavaSDK)\n\uD83C\uDF89StarRiver群管系统\uD83C\uDF89");

           } else if (GroupMessageString.equals("随机动漫")) {
               try {
                   Image image= Contact.uploadImage(ListenGroup.getSubject(),new URL("https://www.dmoe.cc/random.php").openConnection().getInputStream());
                   ListenGroup.getSubject().sendMessage("图片获取中...");
                   ListenGroup.getSubject().sendMessage(image);

               } catch (IOException e) {
                   ListenGroup.getSubject().sendMessage("请求出错...");
                   throw new RuntimeException(e);
               }
           } else if (GroupMessageString.equals("运行状态")) {
              String java_Version=System.getProperty("java.version");

              String Os_Name=System.getProperty("os.name");
              String Os_Arch=System.getProperty("os.arch");
               long endTime = System.currentTimeMillis();
               long usedTime = (endTime-startTime)/1000;
               ListenGroup.getSubject().sendMessage("⚡运行中...\n⚡插件名:StarRiver\n⚡插件版本:1.0.0\n⚡Java版本:"+java_Version+"\n⚡系统:"+Os_Name+"\n⚡系统架构:"+Os_Arch+"\n⚡运行时长:"+usedTime+"秒\n\uD83C\uDF89StarRiver群管系统\uD83C\uDF89");
           } else if (GroupMessageString.equals("随机美女")) {
               try {
                   Image image= Contact.uploadImage(ListenGroup.getSubject(),new URL("https://cdn.seovx.com/?mom=302").openConnection().getInputStream());
                   ListenGroup.getSubject().sendMessage("图片获取中...");
                   ListenGroup.getSubject().sendMessage(image);

               } catch (IOException e) {
                   ListenGroup.getSubject().sendMessage("请求出错...");
                   throw new RuntimeException(e);
               }

           }
       });
    }
}




























