package com.example.Email;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.MessagingException;

public class EmailUtil {

    public static void sendAttachmentEmail(Session session, String toEmail, String filepath, String filename){
        try{
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("bettercrypt@yahoo.com", "BetterCrypt INC"));
            msg.setSubject("Here's your encrypted file", "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Fill the message
            messageBodyPart.setContent(getBody(), "text/html");
            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();
            // Set text message part
            multipart.addBodyPart(messageBodyPart);
            // Second part is attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filepath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            // Send the complete message parts
            msg.setContent(multipart);
            // Send message
            Transport.send(msg);
            System.out.println("EMail Sent Successfully with attachment!!");
        }catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void sendEmail(String to, String filepath, String filename) {
        final String from = "bettercrypt@yahoo.com";
        String host = "smtp.mail.yahoo.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("bettercrypt", "dnxuknsiygwlcmoz");
            }
        });
        session.setDebug(true);
        EmailUtil.sendAttachmentEmail(session, to, filepath, filename);
    }

    public static String getBody() {
        return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "  <!--[if gte mso 9]>\n" +
                "  <xml>\n" +
                "    <o:OfficeDocumentSettings>\n" +
                "      <o:AllowPNG/>\n" +
                "      <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "    </o:OfficeDocumentSettings>\n" +
                "  </xml>\n" +
                "  <![endif]-->\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                "  <title></title>\n" +
                "\n" +
                "  <style type=\"text/css\">\n" +
                "    table, td { color: #000000; } a { color: #000000; text-decoration: underline; }\n" +
                "    @media only screen and (min-width: 620px) {\n" +
                "      .u-row {\n" +
                "        width: 600px !important;\n" +
                "      }\n" +
                "      .u-row .u-col {\n" +
                "        vertical-align: top;\n" +
                "      }\n" +
                "\n" +
                "      .u-row .u-col-50 {\n" +
                "        width: 300px !important;\n" +
                "      }\n" +
                "\n" +
                "      .u-row .u-col-100 {\n" +
                "        width: 600px !important;\n" +
                "      }\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    @media (max-width: 620px) {\n" +
                "      .u-row-container {\n" +
                "        max-width: 100% !important;\n" +
                "        padding-left: 0px !important;\n" +
                "        padding-right: 0px !important;\n" +
                "      }\n" +
                "      .u-row .u-col {\n" +
                "        min-width: 320px !important;\n" +
                "        max-width: 100% !important;\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "      .u-row {\n" +
                "        width: calc(100% - 40px) !important;\n" +
                "      }\n" +
                "      .u-col {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      .u-col > div {\n" +
                "        margin: 0 auto;\n" +
                "      }\n" +
                "    }\n" +
                "    body {\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "      background: #1b1e21;\n" +
                "    }\n" +
                "\n" +
                "    table,\n" +
                "    tr,\n" +
                "    td {\n" +
                "      vertical-align: top;\n" +
                "      border-collapse: collapse;\n" +
                "    }\n" +
                "\n" +
                "    p {\n" +
                "      margin: 0;\n" +
                "    }\n" +
                "\n" +
                "    .ie-container table,\n" +
                "    .mso-container table {\n" +
                "      table-layout: fixed;\n" +
                "    }\n" +
                "\n" +
                "    * {\n" +
                "      line-height: inherit;\n" +
                "    }\n" +
                "\n" +
                "    a[x-apple-data-detectors='true'] {\n" +
                "      color: inherit !important;\n" +
                "      text-decoration: none !important;\n" +
                "    }\n" +
                "\n" +
                "  </style>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Lato:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f9f9f9;color: #000000\">\n" +
                "<!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
                "<!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
                "<table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f9f9f9;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "  <tbody>\n" +
                "  <tr style=\"vertical-align: top\">\n" +
                "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #f9f9f9;\"><![endif]-->\n" +
                "\n" +
                "\n" +
                "      <div class=\"u-row-container\" style=\"padding: 0px;background-color: #f9f9f9\">\n" +
                "        <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\">\n" +
                "          <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "            <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #f9f9f9;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\n" +
                "\n" +
                "            <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                "            <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "              <div style=\"width: 100% !important;\">\n" +
                "                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:15px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #f9f9f9;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                "                        <tbody>\n" +
                "                        <tr style=\"vertical-align: top\">\n" +
                "                          <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                "                            <span>&#160;</span>\n" +
                "                          </td>\n" +
                "                        </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "            <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "      <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "        <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                "          <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "            <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
                "\n" +
                "            <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                "            <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "              <div style=\"width: 100% !important;\">\n" +
                "                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:25px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                        <tr>\n" +
                "                          <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "\n" +
                "                            <img align=\"center\" border=\"0\" src=\"../../../../webapp/assets/img/image-4.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 300%;max-width: 300px;\" width=\"300\"/>\n" +
                "\n" +
                "                          </td>\n" +
                "                        </tr>\n" +
                "                      </table>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "            <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "      <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "        <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #161a39;\">\n" +
                "          <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "            <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #161a39;\"><![endif]-->\n" +
                "\n" +
                "            <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                "            <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "              <div style=\"width: 100% !important;\">\n" +
                "                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:35px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                        <tr>\n" +
                "                          <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "\n" +
                "                            <img align=\"center\" border=\"0\" src=\"../../../../webapp/assets/img/image-1.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 10%;max-width: 58px;\" width=\"58\"/>\n" +
                "\n" +
                "                          </td>\n" +
                "                        </tr>\n" +
                "                      </table>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <div style=\"line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                "                        <p style=\"font-size: 14px; line-height: 140%; text-align: center;\"><span style=\"font-size: 28px; line-height: 39.2px; color: #ffffff; font-family: Lato, sans-serif;\">Please Download Your Encrypted File</span></p>\n" +
                "                      </div>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "            <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "      <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "        <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                "          <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "            <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
                "\n" +
                "            <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                "            <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "              <div style=\"width: 100% !important;\">\n" +
                "                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 40px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <div style=\"line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                "                        <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #666666;\">Hello,</span></p>\n" +
                "                        <p style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\n" +
                "                        <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #666666;\">We have sent you this email in response to your sender's request to send the encrypted file to you.</span></p>\n" +
                "                        <p style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\n" +
                "                        <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #666666;\">To decrypt the file, please follow the link below: </span></p>\n" +
                "                      </div>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 40px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <div align=\"left\">\n" +
                "                        <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;font-family:'Lato',sans-serif;\"><tr><td style=\"font-family:'Lato',sans-serif;\" align=\"left\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://localhost:8080/BetterCrypt_war_exploded/image-decrypt.jsp\" style=\"height:47px; v-text-anchor:middle; width:155px;\" arcsize=\"2%\" stroke=\"f\" fillcolor=\"#18163a\"><w:anchorlock/><center style=\"color:#FFFFFF;font-family:'Lato',sans-serif;\"><![endif]-->\n" +
                "                        <a href=\"http://localhost:8080/BetterCrypt_war_exploded/image-decrypt.jsp\" target=\"_blank\" style=\"box-sizing: border-box;display: inline-block;font-family:'Lato',sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #FFFFFF; background-color: #18163a; border-radius: 1px; -webkit-border-radius: 1px; -moz-border-radius: 1px; width:auto; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;\">\n" +
                "                          <span style=\"display:block;padding:15px 40px;line-height:120%;\">Decrypt File</span>\n" +
                "                        </a>\n" +
                "                        <!--[if mso]></center></v:roundrect></td></tr></table><![endif]-->\n" +
                "                      </div>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 40px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <div style=\"line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                "                        <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"color: #888888; font-size: 14px; line-height: 19.6px;\"><em><span style=\"font-size: 16px; line-height: 22.4px;\">Please ignore this email if the encrypted file wasn't suppossed to reach you.</span></em></span><br /><span style=\"color: #888888; font-size: 14px; line-height: 19.6px;\"><em><span style=\"font-size: 16px; line-height: 22.4px;\">&nbsp;</span></em></span></p>\n" +
                "                      </div>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "            <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "      <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "        <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #18163a;\">\n" +
                "          <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "            <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #18163a;\"><![endif]-->\n" +
                "\n" +
                "            <!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 20px 20px 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                "            <div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
                "              <div style=\"width: 100% !important;\">\n" +
                "                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 20px 20px 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <div style=\"line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                "                        <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 16px; line-height: 22.4px; color: #ecf0f1;\">Contact</span></p>\n" +
                "                        <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 14px; line-height: 19.6px; color: #ecf0f1;\"> bettercrypt@yahoo.com</span></p>\n" +
                "                      </div>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "            <!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 0px 0px 0px 20px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                "            <div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
                "              <div style=\"width: 100% !important;\">\n" +
                "                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px 0px 0px 20px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:25px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <div align=\"left\">\n" +
                "                        <div style=\"display: table; max-width:187px;\">\n" +
                "                          <!--[if (mso)|(IE)]><table width=\"187\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"left\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:187px;\"><tr><![endif]-->\n" +
                "\n" +
                "\n" +
                "                          <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                "                          <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                "                            <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "                              <a href=\" https://www.facebook.com/shubhankar.haldia.1\" title=\"Facebook\" target=\"_blank\">\n" +
                "                                <img src=\"../../../../webapp/assets/img/image-2.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                "                              </a>\n" +
                "                            </td></tr>\n" +
                "                            </tbody></table>\n" +
                "                          <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "\n" +
                "                          <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                "                          <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                "                            <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "                              <a href=\" https://twitter.com/Shubhan71506563\" title=\"Twitter\" target=\"_blank\">\n" +
                "                                <img src=\"../../../../webapp/assets/img/image-5.png\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                "                              </a>\n" +
                "                            </td></tr>\n" +
                "                            </tbody></table>\n" +
                "                          <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "\n" +
                "                          <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                "                          <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                "                            <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "                              <a href=\" https://www.instagram.com/shubhankarhaldia\" title=\"Instagram\" target=\"_blank\">\n" +
                "                                <img src=\"../../../../webapp/assets/img/image-6.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                "                              </a>\n" +
                "                            </td></tr>\n" +
                "                            </tbody></table>\n" +
                "                          <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "\n" +
                "                          <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\n" +
                "                          <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
                "                            <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "                              <a href=\" https://in.linkedin.com/in/shubhankar-haldia-8b57b4202\" title=\"LinkedIn\" target=\"_blank\">\n" +
                "                                <img src=\"../../../../webapp/assets/img/image-3.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                "                              </a>\n" +
                "                            </td></tr>\n" +
                "                            </tbody></table>\n" +
                "                          <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "\n" +
                "\n" +
                "                          <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:5px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <div style=\"line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                "                        <p style=\"line-height: 140%; font-size: 14px;\"><span style=\"font-size: 14px; line-height: 19.6px;\"><span style=\"color: #ecf0f1; font-size: 14px; line-height: 19.6px;\"><span style=\"line-height: 19.6px; font-size: 14px;\">BetterCrypt &copy;&nbsp; All Rights Reserved</span></span></span></p>\n" +
                "                      </div>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "            <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "      <div class=\"u-row-container\" style=\"padding: 0px;background-color: #f9f9f9\">\n" +
                "        <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #1c103b;\">\n" +
                "          <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "            <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #f9f9f9;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #1c103b;\"><![endif]-->\n" +
                "\n" +
                "            <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                "            <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "              <div style=\"width: 100% !important;\">\n" +
                "                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:15px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #1c103b;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                "                        <tbody>\n" +
                "                        <tr style=\"vertical-align: top\">\n" +
                "                          <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                "                            <span>&#160;</span>\n" +
                "                          </td>\n" +
                "                        </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "            <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "      <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "        <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\">\n" +
                "          <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "            <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\n" +
                "\n" +
                "            <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                "            <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "              <div style=\"width: 100% !important;\">\n" +
                "                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                "\n" +
                "                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                  <tbody>\n" +
                "                  <tr>\n" +
                "                    <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 40px 30px 20px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                      <div style=\"line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                "\n" +
                "                      </div>\n" +
                "\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "\n" +
                "                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "            <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "\n" +
                "      <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "<!--[if mso]></div><![endif]-->\n" +
                "<!--[if IE]></div><![endif]-->\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";
    }
}
