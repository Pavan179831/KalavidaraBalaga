package com.kalavidarabalaga.app.data;

/**
 * SharedPreferences helper for:
 * - User profile (name, phone, address, photoUri)
 * - Local bookings list
 * - Notification count
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u000bH\u0002J\u000e\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000bJ\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+J\u0018\u0010-\u001a\u0004\u0018\u00010\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020(J\u0016\u00100\u001a\u00020(2\f\u00101\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J(\u00102\u001a\u0004\u0018\u00010\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bJ\u0018\u00105\u001a\u0004\u0018\u00010\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bJ\u000e\u00107\u001a\u00020(2\u0006\u00108\u001a\u00020,J\u000e\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020,R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R$\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R$\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R$\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010\u00a8\u0006;"}, d2 = {"Lcom/kalavidarabalaga/app/data/UserPreferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "v", "", "isLoggedIn", "()Z", "setLoggedIn", "(Z)V", "", "loggedInUsername", "getLoggedInUsername", "()Ljava/lang/String;", "setLoggedInUsername", "(Ljava/lang/String;)V", "", "notifCount", "getNotifCount", "()I", "setNotifCount", "(I)V", "prefs", "Landroid/content/SharedPreferences;", "userAddress", "getUserAddress", "setUserAddress", "userName", "getUserName", "setUserName", "userPhone", "getUserPhone", "setUserPhone", "userPhotoUri", "getUserPhotoUri", "setUserPhotoUri", "accountExists", "username", "deleteBooking", "", "id", "getBookings", "", "Lcom/kalavidarabalaga/app/data/LocalBooking;", "login", "password", "logout", "persistList", "list", "register", "name", "phone", "resetPassword", "newPassword", "saveBooking", "booking", "updateBooking", "updated", "app_debug"})
public final class UserPreferences {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    
    public UserPreferences(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.NotNull()
    java.lang.String v) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserPhone() {
        return null;
    }
    
    public final void setUserPhone(@org.jetbrains.annotations.NotNull()
    java.lang.String v) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserAddress() {
        return null;
    }
    
    public final void setUserAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String v) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserPhotoUri() {
        return null;
    }
    
    public final void setUserPhotoUri(@org.jetbrains.annotations.NotNull()
    java.lang.String v) {
    }
    
    public final int getNotifCount() {
        return 0;
    }
    
    public final void setNotifCount(int v) {
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    public final void setLoggedIn(boolean v) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLoggedInUsername() {
        return null;
    }
    
    public final void setLoggedInUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String v) {
    }
    
    /**
     * Register a new account. Returns error string or null on success.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String register(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
        return null;
    }
    
    /**
     * Login. Returns error string or null on success.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    /**
     * Reset password. Returns error string or null on success.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String resetPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String newPassword) {
        return null;
    }
    
    /**
     * Logout — clear session
     */
    public final void logout() {
    }
    
    private final boolean accountExists(java.lang.String username) {
        return false;
    }
    
    public final void saveBooking(@org.jetbrains.annotations.NotNull()
    com.kalavidarabalaga.app.data.LocalBooking booking) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.kalavidarabalaga.app.data.LocalBooking> getBookings() {
        return null;
    }
    
    public final void updateBooking(@org.jetbrains.annotations.NotNull()
    com.kalavidarabalaga.app.data.LocalBooking updated) {
    }
    
    public final void deleteBooking(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    private final void persistList(java.util.List<com.kalavidarabalaga.app.data.LocalBooking> list) {
    }
}