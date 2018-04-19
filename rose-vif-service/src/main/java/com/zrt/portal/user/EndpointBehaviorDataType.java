
package com.zrt.portal.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		            The EndpointBehaviorDataType will hold the parameters for EndpointBehavior configurations.
 * 		          
 * 
 * <p>EndpointBehaviorDataType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="EndpointBehaviorDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="windowSizeHeight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="windowSizeWidth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="windowPositionTop" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="windowPositionBottom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="windowPositionLeft" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="windowPositionRight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="welcomePage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="beautyScreen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="loginModule" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="publicChat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="leftPanel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="inCallSearch" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="inviteParticipants" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="contentSharing" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shareDialogOnJoin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="displayLabels" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="remoteContentAccess" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cameraMuteControl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="muteCameraOnEntry" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="audioMuteControl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="muteAudioOnEntry" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deviceSettings" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pinnedParticipant" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recordConference" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recordingRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exitOnUserHangup" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="automaticallyUpdate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lockUserName" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableAutoAnswer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="participantNotification" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fullScreenVideo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="preIframeUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preIframeSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="topIframeUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="topIframeSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="leftIframeUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="leftIframeSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="rightIframeUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rightIframeSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bottomIframeUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bottomIframeSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="postIframeUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postIframeSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="endpointBehaviorKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndpointBehaviorDataType", propOrder = {
    "windowSizeHeight",
    "windowSizeWidth",
    "windowPositionTop",
    "windowPositionBottom",
    "windowPositionLeft",
    "windowPositionRight",
    "welcomePage",
    "beautyScreen",
    "loginModule",
    "publicChat",
    "leftPanel",
    "inCallSearch",
    "inviteParticipants",
    "contentSharing",
    "shareDialogOnJoin",
    "displayLabels",
    "remoteContentAccess",
    "cameraMuteControl",
    "muteCameraOnEntry",
    "audioMuteControl",
    "muteAudioOnEntry",
    "deviceSettings",
    "pinnedParticipant",
    "recordConference",
    "recordingRole",
    "exitOnUserHangup",
    "automaticallyUpdate",
    "lockUserName",
    "enableAutoAnswer",
    "participantNotification",
    "fullScreenVideo",
    "preIframeUrl",
    "preIframeSize",
    "topIframeUrl",
    "topIframeSize",
    "leftIframeUrl",
    "leftIframeSize",
    "rightIframeUrl",
    "rightIframeSize",
    "bottomIframeUrl",
    "bottomIframeSize",
    "postIframeUrl",
    "postIframeSize",
    "endpointBehaviorKey"
})
public class EndpointBehaviorDataType {

    protected Integer windowSizeHeight;
    protected Integer windowSizeWidth;
    protected Integer windowPositionTop;
    protected Integer windowPositionBottom;
    protected Integer windowPositionLeft;
    protected Integer windowPositionRight;
    @XmlElement(defaultValue = "1")
    protected int welcomePage;
    @XmlElement(defaultValue = "1")
    protected int beautyScreen;
    @XmlElement(defaultValue = "1")
    protected int loginModule;
    @XmlElement(defaultValue = "1")
    protected int publicChat;
    @XmlElement(defaultValue = "1")
    protected int leftPanel;
    @XmlElement(defaultValue = "1")
    protected int inCallSearch;
    @XmlElement(defaultValue = "1")
    protected int inviteParticipants;
    @XmlElement(defaultValue = "1")
    protected int contentSharing;
    @XmlElement(defaultValue = "0")
    protected int shareDialogOnJoin;
    @XmlElement(defaultValue = "1")
    protected int displayLabels;
    @XmlElement(defaultValue = "1")
    protected int remoteContentAccess;
    @XmlElement(defaultValue = "1")
    protected int cameraMuteControl;
    @XmlElement(defaultValue = "1")
    protected int muteCameraOnEntry;
    @XmlElement(defaultValue = "1")
    protected int audioMuteControl;
    @XmlElement(defaultValue = "1")
    protected int muteAudioOnEntry;
    @XmlElement(defaultValue = "1")
    protected int deviceSettings;
    @XmlElement(defaultValue = "0")
    protected int pinnedParticipant;
    @XmlElement(defaultValue = "0")
    protected int recordConference;
    protected String recordingRole;
    @XmlElement(defaultValue = "0")
    protected int exitOnUserHangup;
    @XmlElement(defaultValue = "1")
    protected int automaticallyUpdate;
    @XmlElement(defaultValue = "0")
    protected int lockUserName;
    @XmlElement(defaultValue = "0")
    protected int enableAutoAnswer;
    @XmlElement(defaultValue = "1")
    protected int participantNotification;
    @XmlElement(defaultValue = "0")
    protected int fullScreenVideo;
    protected String preIframeUrl;
    protected Integer preIframeSize;
    protected String topIframeUrl;
    protected Integer topIframeSize;
    protected String leftIframeUrl;
    protected Integer leftIframeSize;
    protected String rightIframeUrl;
    protected Integer rightIframeSize;
    protected String bottomIframeUrl;
    protected Integer bottomIframeSize;
    protected String postIframeUrl;
    protected Integer postIframeSize;
    protected String endpointBehaviorKey;

    /**
     * 获取windowSizeHeight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWindowSizeHeight() {
        return windowSizeHeight;
    }

    /**
     * 设置windowSizeHeight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWindowSizeHeight(Integer value) {
        this.windowSizeHeight = value;
    }

    /**
     * 获取windowSizeWidth属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWindowSizeWidth() {
        return windowSizeWidth;
    }

    /**
     * 设置windowSizeWidth属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWindowSizeWidth(Integer value) {
        this.windowSizeWidth = value;
    }

    /**
     * 获取windowPositionTop属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWindowPositionTop() {
        return windowPositionTop;
    }

    /**
     * 设置windowPositionTop属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWindowPositionTop(Integer value) {
        this.windowPositionTop = value;
    }

    /**
     * 获取windowPositionBottom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWindowPositionBottom() {
        return windowPositionBottom;
    }

    /**
     * 设置windowPositionBottom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWindowPositionBottom(Integer value) {
        this.windowPositionBottom = value;
    }

    /**
     * 获取windowPositionLeft属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWindowPositionLeft() {
        return windowPositionLeft;
    }

    /**
     * 设置windowPositionLeft属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWindowPositionLeft(Integer value) {
        this.windowPositionLeft = value;
    }

    /**
     * 获取windowPositionRight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWindowPositionRight() {
        return windowPositionRight;
    }

    /**
     * 设置windowPositionRight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWindowPositionRight(Integer value) {
        this.windowPositionRight = value;
    }

    /**
     * 获取welcomePage属性的值。
     * 
     */
    public int getWelcomePage() {
        return welcomePage;
    }

    /**
     * 设置welcomePage属性的值。
     * 
     */
    public void setWelcomePage(int value) {
        this.welcomePage = value;
    }

    /**
     * 获取beautyScreen属性的值。
     * 
     */
    public int getBeautyScreen() {
        return beautyScreen;
    }

    /**
     * 设置beautyScreen属性的值。
     * 
     */
    public void setBeautyScreen(int value) {
        this.beautyScreen = value;
    }

    /**
     * 获取loginModule属性的值。
     * 
     */
    public int getLoginModule() {
        return loginModule;
    }

    /**
     * 设置loginModule属性的值。
     * 
     */
    public void setLoginModule(int value) {
        this.loginModule = value;
    }

    /**
     * 获取publicChat属性的值。
     * 
     */
    public int getPublicChat() {
        return publicChat;
    }

    /**
     * 设置publicChat属性的值。
     * 
     */
    public void setPublicChat(int value) {
        this.publicChat = value;
    }

    /**
     * 获取leftPanel属性的值。
     * 
     */
    public int getLeftPanel() {
        return leftPanel;
    }

    /**
     * 设置leftPanel属性的值。
     * 
     */
    public void setLeftPanel(int value) {
        this.leftPanel = value;
    }

    /**
     * 获取inCallSearch属性的值。
     * 
     */
    public int getInCallSearch() {
        return inCallSearch;
    }

    /**
     * 设置inCallSearch属性的值。
     * 
     */
    public void setInCallSearch(int value) {
        this.inCallSearch = value;
    }

    /**
     * 获取inviteParticipants属性的值。
     * 
     */
    public int getInviteParticipants() {
        return inviteParticipants;
    }

    /**
     * 设置inviteParticipants属性的值。
     * 
     */
    public void setInviteParticipants(int value) {
        this.inviteParticipants = value;
    }

    /**
     * 获取contentSharing属性的值。
     * 
     */
    public int getContentSharing() {
        return contentSharing;
    }

    /**
     * 设置contentSharing属性的值。
     * 
     */
    public void setContentSharing(int value) {
        this.contentSharing = value;
    }

    /**
     * 获取shareDialogOnJoin属性的值。
     * 
     */
    public int getShareDialogOnJoin() {
        return shareDialogOnJoin;
    }

    /**
     * 设置shareDialogOnJoin属性的值。
     * 
     */
    public void setShareDialogOnJoin(int value) {
        this.shareDialogOnJoin = value;
    }

    /**
     * 获取displayLabels属性的值。
     * 
     */
    public int getDisplayLabels() {
        return displayLabels;
    }

    /**
     * 设置displayLabels属性的值。
     * 
     */
    public void setDisplayLabels(int value) {
        this.displayLabels = value;
    }

    /**
     * 获取remoteContentAccess属性的值。
     * 
     */
    public int getRemoteContentAccess() {
        return remoteContentAccess;
    }

    /**
     * 设置remoteContentAccess属性的值。
     * 
     */
    public void setRemoteContentAccess(int value) {
        this.remoteContentAccess = value;
    }

    /**
     * 获取cameraMuteControl属性的值。
     * 
     */
    public int getCameraMuteControl() {
        return cameraMuteControl;
    }

    /**
     * 设置cameraMuteControl属性的值。
     * 
     */
    public void setCameraMuteControl(int value) {
        this.cameraMuteControl = value;
    }

    /**
     * 获取muteCameraOnEntry属性的值。
     * 
     */
    public int getMuteCameraOnEntry() {
        return muteCameraOnEntry;
    }

    /**
     * 设置muteCameraOnEntry属性的值。
     * 
     */
    public void setMuteCameraOnEntry(int value) {
        this.muteCameraOnEntry = value;
    }

    /**
     * 获取audioMuteControl属性的值。
     * 
     */
    public int getAudioMuteControl() {
        return audioMuteControl;
    }

    /**
     * 设置audioMuteControl属性的值。
     * 
     */
    public void setAudioMuteControl(int value) {
        this.audioMuteControl = value;
    }

    /**
     * 获取muteAudioOnEntry属性的值。
     * 
     */
    public int getMuteAudioOnEntry() {
        return muteAudioOnEntry;
    }

    /**
     * 设置muteAudioOnEntry属性的值。
     * 
     */
    public void setMuteAudioOnEntry(int value) {
        this.muteAudioOnEntry = value;
    }

    /**
     * 获取deviceSettings属性的值。
     * 
     */
    public int getDeviceSettings() {
        return deviceSettings;
    }

    /**
     * 设置deviceSettings属性的值。
     * 
     */
    public void setDeviceSettings(int value) {
        this.deviceSettings = value;
    }

    /**
     * 获取pinnedParticipant属性的值。
     * 
     */
    public int getPinnedParticipant() {
        return pinnedParticipant;
    }

    /**
     * 设置pinnedParticipant属性的值。
     * 
     */
    public void setPinnedParticipant(int value) {
        this.pinnedParticipant = value;
    }

    /**
     * 获取recordConference属性的值。
     * 
     */
    public int getRecordConference() {
        return recordConference;
    }

    /**
     * 设置recordConference属性的值。
     * 
     */
    public void setRecordConference(int value) {
        this.recordConference = value;
    }

    /**
     * 获取recordingRole属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordingRole() {
        return recordingRole;
    }

    /**
     * 设置recordingRole属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordingRole(String value) {
        this.recordingRole = value;
    }

    /**
     * 获取exitOnUserHangup属性的值。
     * 
     */
    public int getExitOnUserHangup() {
        return exitOnUserHangup;
    }

    /**
     * 设置exitOnUserHangup属性的值。
     * 
     */
    public void setExitOnUserHangup(int value) {
        this.exitOnUserHangup = value;
    }

    /**
     * 获取automaticallyUpdate属性的值。
     * 
     */
    public int getAutomaticallyUpdate() {
        return automaticallyUpdate;
    }

    /**
     * 设置automaticallyUpdate属性的值。
     * 
     */
    public void setAutomaticallyUpdate(int value) {
        this.automaticallyUpdate = value;
    }

    /**
     * 获取lockUserName属性的值。
     * 
     */
    public int getLockUserName() {
        return lockUserName;
    }

    /**
     * 设置lockUserName属性的值。
     * 
     */
    public void setLockUserName(int value) {
        this.lockUserName = value;
    }

    /**
     * 获取enableAutoAnswer属性的值。
     * 
     */
    public int getEnableAutoAnswer() {
        return enableAutoAnswer;
    }

    /**
     * 设置enableAutoAnswer属性的值。
     * 
     */
    public void setEnableAutoAnswer(int value) {
        this.enableAutoAnswer = value;
    }

    /**
     * 获取participantNotification属性的值。
     * 
     */
    public int getParticipantNotification() {
        return participantNotification;
    }

    /**
     * 设置participantNotification属性的值。
     * 
     */
    public void setParticipantNotification(int value) {
        this.participantNotification = value;
    }

    /**
     * 获取fullScreenVideo属性的值。
     * 
     */
    public int getFullScreenVideo() {
        return fullScreenVideo;
    }

    /**
     * 设置fullScreenVideo属性的值。
     * 
     */
    public void setFullScreenVideo(int value) {
        this.fullScreenVideo = value;
    }

    /**
     * 获取preIframeUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreIframeUrl() {
        return preIframeUrl;
    }

    /**
     * 设置preIframeUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreIframeUrl(String value) {
        this.preIframeUrl = value;
    }

    /**
     * 获取preIframeSize属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPreIframeSize() {
        return preIframeSize;
    }

    /**
     * 设置preIframeSize属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPreIframeSize(Integer value) {
        this.preIframeSize = value;
    }

    /**
     * 获取topIframeUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopIframeUrl() {
        return topIframeUrl;
    }

    /**
     * 设置topIframeUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopIframeUrl(String value) {
        this.topIframeUrl = value;
    }

    /**
     * 获取topIframeSize属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTopIframeSize() {
        return topIframeSize;
    }

    /**
     * 设置topIframeSize属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTopIframeSize(Integer value) {
        this.topIframeSize = value;
    }

    /**
     * 获取leftIframeUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeftIframeUrl() {
        return leftIframeUrl;
    }

    /**
     * 设置leftIframeUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeftIframeUrl(String value) {
        this.leftIframeUrl = value;
    }

    /**
     * 获取leftIframeSize属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLeftIframeSize() {
        return leftIframeSize;
    }

    /**
     * 设置leftIframeSize属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLeftIframeSize(Integer value) {
        this.leftIframeSize = value;
    }

    /**
     * 获取rightIframeUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRightIframeUrl() {
        return rightIframeUrl;
    }

    /**
     * 设置rightIframeUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRightIframeUrl(String value) {
        this.rightIframeUrl = value;
    }

    /**
     * 获取rightIframeSize属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRightIframeSize() {
        return rightIframeSize;
    }

    /**
     * 设置rightIframeSize属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRightIframeSize(Integer value) {
        this.rightIframeSize = value;
    }

    /**
     * 获取bottomIframeUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBottomIframeUrl() {
        return bottomIframeUrl;
    }

    /**
     * 设置bottomIframeUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBottomIframeUrl(String value) {
        this.bottomIframeUrl = value;
    }

    /**
     * 获取bottomIframeSize属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBottomIframeSize() {
        return bottomIframeSize;
    }

    /**
     * 设置bottomIframeSize属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBottomIframeSize(Integer value) {
        this.bottomIframeSize = value;
    }

    /**
     * 获取postIframeUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostIframeUrl() {
        return postIframeUrl;
    }

    /**
     * 设置postIframeUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostIframeUrl(String value) {
        this.postIframeUrl = value;
    }

    /**
     * 获取postIframeSize属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPostIframeSize() {
        return postIframeSize;
    }

    /**
     * 设置postIframeSize属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPostIframeSize(Integer value) {
        this.postIframeSize = value;
    }

    /**
     * 获取endpointBehaviorKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndpointBehaviorKey() {
        return endpointBehaviorKey;
    }

    /**
     * 设置endpointBehaviorKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndpointBehaviorKey(String value) {
        this.endpointBehaviorKey = value;
    }

}
