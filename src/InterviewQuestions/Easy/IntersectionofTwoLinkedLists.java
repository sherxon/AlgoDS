package InterviewQuestions.Easy;

import InterviewQuestions.ListNode;

/**
 * Created by sherxon on 12/28/16.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode x, ListNode y) {
        ListNode xx=x;
        int cx=0;
        ListNode yy=y;
        int cy=0;
        while(xx!=null || yy !=null){
            if(xx!=null){
                xx=xx.next;
                cx++;
            }
            if(yy!=null) {
                yy=yy.next;
                cy++;
            }
        }
        xx=x;
        yy=y;
        if(cx>cy){
            for(int i=0; i<cx-cy; i++)xx=xx.next;
        }else if(cx<cy){
            for(int i=0; i<cy-cx; i++)yy=yy.next;
        }
        while(yy!=null && xx!=null){
            if(yy==xx)return xx;
            yy=yy.next;
            xx=xx.next;
        }

        return null;
    }
}
