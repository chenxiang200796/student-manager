package com.hnufe.contacts;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Student>list=new ArrayList<>();
        while(true){
            System.out.println("----学生信息管理系统----");
            System.out.println("1 添加学生/ 2 显示全部/ 3 按学号查找/ 4 删除学生/ 0 退出");
            int choose=Integer.parseInt(sc.nextLine());
            if(choose==0) break;
            else if (choose==1){
                System.out.println("请输入学生信息，格式：学号 姓名 性别 电话");
                String info=sc.nextLine();
                String[] parts=info.trim().split("\\s+");
                if(parts.length<4){
                    System.out.println("输入格式不对");
                }else{
                    Student s=new Student(parts[0],parts[1],parts[2],parts[3]);
                    list.add(s);
                    System.out.println("添加成功"+s);
                }

            }
            else if(choose==2){
                System.out.println("----全部学生----");
                for(Student s:list){
                    System.out.println(s);
                }
                if(list.size()==0){
                    System.out.println("暂时没有学生信息");
                }
            }
            else if(choose==3){
                System.out.println("请输入要查找的学号:");
                String id=sc.nextLine();
                Student found=findById(list,id);
                if(found==null){
                    System.out.println("未查找到学号");
                }
                else {
                    System.out.println("找到:"+found);
                }
            }
            else if(choose==4){
                System.out.println("请输入要删除的学号:");
                String id=sc.nextLine();
                Student found=findById(list,id);
                if(found==null){
                    System.out.println("未查找到学号");
                }
                else {
                    list.remove(found);
                    System.out.println("删除成功" + found);
                }
            }
        }

        }

    public static Student findById(ArrayList<Student>list,String id){//根据学号查找学生
        for(Student s:list){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }


}


