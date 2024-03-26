package com.example.proco.chat;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proco.R;
import com.google.firebase.database.core.Context;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatViewsHolder> {

    private List<ChatObject> chatList;
    private Context context;

    public ChatAdapter(List<ChatObject> dataSetChat, ChatActivity chatActivity) {
    }

    @NonNull
    @Override
    public ChatViewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);
        ChatViewsHolder rcv = new ChatViewsHolder(layoutView);

        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewsHolder holder, int position) {

        holder.mMessage.setText(chatList.get(position).getMessage());

        if (chatList.get(position).getCurrentUser())    {
            GradientDrawable shape = new GradientDrawable();
            shape.setCornerRadius(20);
            float[] radii = {25, 25, 3, 3, 25, 25, 25, 25}; // array representing the corner radii for each corner
            shape.setCornerRadii(radii);
            shape.setColor(Color.parseColor("#5fc9f8"));
            holder.mContainer.setGravity(Gravity.END);
            holder.mMessage.setBackground(shape);
            holder.mMessage.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else{
            GradientDrawable shape = new GradientDrawable();
            shape.setCornerRadius(20);
            float[] radii = {25, 25, 3, 3, 25, 25, 25, 25}; // array representing the corner radii for each corner
            shape.setCornerRadii(radii);
            shape.setColor(Color.parseColor("#53d769"));
            holder.mContainer.setGravity(Gravity.START);
            holder.mMessage.setBackground(shape);
            holder.mMessage.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    @Override
    public int getItemCount() {
        return this.chatList.size();
    }
}
