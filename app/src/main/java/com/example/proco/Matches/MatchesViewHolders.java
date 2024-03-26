package com.example.proco.Matches;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proco.chat.ChatActivity;
import com.example.proco.R;

public class MatchesViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView mMatchId,mMatchName,mLastTimeStamp,mLastMessage,mNeed,mGive,mBudget,mProfile;
    public ImageView mNotificationDot;
    public ImageView mMatchImage;

    public MatchesViewHolders (@NonNull View itemView)
    {
        super(itemView);
        itemView.setOnClickListener(this);
        mMatchId=(TextView) itemView.findViewById(R.id.Matchid);
        mMatchName=(TextView) itemView.findViewById(R.id.MatchName);
        mLastMessage=(TextView) itemView.findViewById(R.id.lastMessage);
        mLastTimeStamp=(TextView) itemView.findViewById(R.id.lastTimeStamp);

        mNeed=(TextView) itemView.findViewById(R.id.needid);
        mGive=(TextView) itemView.findViewById(R.id.giveid);
        mBudget=(TextView) itemView.findViewById(R.id.budgetid);
        mProfile=(TextView) itemView.findViewById(R.id.profileid);
        mMatchImage=(ImageView) itemView.findViewById(R.id.MatchImage);
        mNotificationDot=(ImageView) itemView.findViewById(R.id.notification_dot);
    }
    @Override
    public void onClick(View v)
    {
        Context context =v.getContext();
        Intent intent = new Intent(context, ChatActivity.class);

        Bundle b = new Bundle();
        b.putString("matchId", mMatchId.getText().toString());
        b.putString("matchName", mMatchName.getText().toString());
        b.putString("lastMessage", mLastMessage.getText().toString());
        b.putString("lastTimeStamp", mLastTimeStamp.getText().toString());
        b.putString("budget", mBudget.getText().toString());
        b.putString("need", mNeed.getText().toString());
        b.putString("profile", mProfile.getText().toString());
        intent.putExtras(b);
        v.getContext().startActivity(intent);
    }

}
