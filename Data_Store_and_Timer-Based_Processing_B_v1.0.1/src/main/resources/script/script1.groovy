import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper
 
def Message processData(Message message) {
 
    def reader = message.getBody(java.io.Reader)
    def json = new JsonSlurper().parse(reader)
 
    message.setProperty(
        "CurrentStatus",
        json.CurrentStatus ?: "NOT_FOUND"
    )
 
    message.setProperty(
        "LastLocation",
        json.LastLocation ?: ""
    )
 
    message.setProperty(
        "UpdatedAt",
        json.UpdatedAt ?: ""
    )
 
    return message
}