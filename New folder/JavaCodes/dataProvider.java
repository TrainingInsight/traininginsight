package sonatasomething.thesecond;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dataProvider {
    public static HashMap<String,List<String>> getInfo()
    {
        HashMap<String,List<String>> Skills_details=new HashMap<String,List<String>>();
        List<String> item1 =new ArrayList<String>();
        item1.add("Skill portal will show the internal assessment scores and all skill and training related information on the finger tips.");
        List<String> item2 =new ArrayList<String>();
        item2.add("Skill card is generated based on the internal assessment that you have taken recently");
        List<String> item3 = new ArrayList<String>();
        item3.add("Training plan is generated based on the skill gaps identified through internal assessments.");
        List<String> item4 = new ArrayList<String>();
        item4.add("Please visit My calender");
        List<String> item5 = new ArrayList<String>();
        item5.add("You can send mail to support@sonata-software.com . Include 'Tech training' in the subject line for faster response.");
        List<String> item6 = new ArrayList<String>();
        item6.add("2 or 3 courses per month.");
        List<String> item7 = new ArrayList<String>();
        item7.add("We recommend you to open a thread in Tibbr to encourage expert guidance.");
        List<String> item8 = new ArrayList<String>();
        item8.add("You can send mail to support@sonata-software.com . Include 'Tech training' in the subject line for faster response.");
        List<String> item9 = new ArrayList<String>();
        item9.add("Send request to jayashree.r@sonata-software.com, mentioning the program name that you would like to attend.");
        List<String> item10 = new ArrayList<String>();
        item10.add("Send mail to support@sonata-software.com with your request");
        List<String> item11 = new ArrayList<String>();
        item11.add("You can approach the Tech team representative who conducted assessment for you.");
        List<String> item12 = new ArrayList<String>();
        item12.add("To enhance/strengthen employee skills.");
        List<String> item13 = new ArrayList<String>();
        item13.add("You can update your skills/certification data in Orbit");
        List<String> item14 = new ArrayList<String>();
        item14.add("As and when you acquire new certification.");
        List<String> item15 = new ArrayList<String>();
        item15.add("You have to update your skills at least once in six months.");


        Skills_details.put("What is skill portal?", item1);
        Skills_details.put("What is skill card?", item2);
        Skills_details.put("How my training plan is created?",item3);
        Skills_details.put("What are the courses available in LMS ??",item4);
        Skills_details.put("How do I enrol myself to an LMS course?",item5);
        Skills_details.put("How many Courses I can be enrolled simultaneously ?",item6);
        Skills_details.put("Whom I can approach, If I have subject related doubt while going through self learning course ?",item7);
        Skills_details.put("Whom should I approach to attend /send request for a training ?",item8);
        Skills_details.put("How do I send request to attend an calendar training program ?",item9);
        Skills_details.put("I am interested in taking internal assessment.",item10);
        Skills_details.put("I have not yet received my scores",item11);
        Skills_details.put("What is the objective of assessment ?",item12);
        Skills_details.put("How to update my certification?",item13);
        Skills_details.put("When should I update my certifications?",item14);
        Skills_details.put("When should I update my skills? ",item15);



        return Skills_details;

    };
};
