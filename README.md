# Main_Project
#activity_main.xml file

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#1F1F22"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="278dp"
        android:layout_height="64dp"
        android:text="GRAVITY"
        android:textAlignment="center"
        android:textColor="#F6F2F2"
        android:textSize="60sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.431" />

    <Button
        android:id="@+id/button2"
        android:layout_width="164dp"
        android:layout_height="66dp"
        android:text="Log In"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.627" />
</androidx.constraintlayout.widget.ConstraintLayout>
