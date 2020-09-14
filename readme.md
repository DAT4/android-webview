# Øvelser for at lære at lave android apps (Dag 1)

I disse øvelser har jeg lavet en app som kan bruges til at browse webbet.

## Øvelse 4: Lave en hovedmenu til en app

Jeg har designet en liste af knapper i xml.

```xml
<LinearLayout
    android:id="@+id/linearLayout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintTop_toTopOf="parent">


    <Button
        android:id="@+id/browse"
        android:background="@color/colorPrimary"
        android:text="Go Browse"
        android:textColor="@color/colorAccent"
        android:textSize="30sp"
        android:layout_width="300dp"
        android:layout_marginTop="10dp"
        android:layout_height="80dp" />

    <Button
        android:id="@+id/exit"
        android:background="@color/colorAccent"
        android:text="Exit"
        android:textColor="@color/colorPrimary"
        android:textSize="30sp"
        android:layout_width="300dp"
        android:layout_marginTop="10dp"
        android:layout_height="80dp" />
</LinearLayout>
```

## Øvelse 5: Lave en webbrowser

Nemt nok, bare lav en xml med WebView

```kotlin
<WebView
    android:id="@+id/browser"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_weight="1"
    app:layout_constraintBottom_toTopOf="@+id/linearLayout2" />
```

## Øvelse 6: Udforsk AndroidElementer

Jeg klikker på alt og søger på youtube og læser bøger.


## Øvelse 7: Lytte efter hændelser på views

Svaret på i spørgsmål 10.

## Øvelse 8: Udforsk intents og aktiviteter

[x] Done

## Øvelse 9: Emulatorer og fysiske telefoner 

Jeg bruger kun min telefon fordi min pc ikke er lavet til at køre så tunge programmer.....

## Øvelse 10: Prøv implicitte og eksplicitte intents

Implicitte intents er fx at jeg skifter **Activity** når jeg klikker på en knap

```kotlin
browse.setOnClickListener {
    val intent = Intent(this, WebActivity::class.java)
    startActivity(intent)
}
```

## Øvelse 11: Versionering af dit eget projekt

Jeg har bare taget src/main mappen og lagt den op her..
