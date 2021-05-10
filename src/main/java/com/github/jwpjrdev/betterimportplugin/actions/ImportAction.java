package com.github.jwpjrdev.betterimportplugin.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.github.jwpjrdev.betterimportplugin.Language;
import com.github.jwpjrdev.betterimportplugin.MyBundle;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;

// PsiJavaCodeReferenceElement:AnAction
public class ImportAction extends AnAction {
    
    /**
     * Only showsthe popup if:
     * <ul>
     *     <li>a project is open</li>
     *     <li>an editor is open</li>
     *     TODO: remove <li>the editor is for a JVM file</li>
     *     <li>the editor is in a writable file</li>
     * </ul>
     *
     * @param event Event related to this action
     */
    // TODO: handle static importing
    // PsiJavaCodeReferenceElement:Override
    @Override // PsiJavaCodeReferenceElement:NotNull - check for PsiJavaToken:AT/PsiAnnotation to filter out non-annotations
    // PsiJavaCodeReferenceElement:AnActionEvent
    public void actionPerformed(@NotNull AnActionEvent event) {
        // TODO: check whether they're 1) in a project and are 2) in a Java file
        // TODO: perhaps support other JVM languages in the future
        // PsiJavaCodeReferenceElement:Project
        final Project project = event.getProject();
        // PsiJavaCodeReferenceElement:Editor
        // PsiReferenceExpression:CommonDataKeys - if it's an enum, 1) filter out non-enums and 2) filter out enums that don't have that value
        // Turns out that PsiReferenceExpression applies to variables as well, make sure to check that.
        final Editor editor = event.getData(CommonDataKeys.EDITOR);
        
        if (project == null || editor == null) {
            System.out.println("Project or editor is null");
            return;
        }
        
        // no null check for the document because it can't be null
        // PsiJavaCodeReferenceElement:Document
        final Document document = editor.getDocument();
    
        if (!document.isWritable()) {
            System.out.println("Document is not writable");
            return;
        }
    
        System.out.println("Import action triggered");
    
        final String fileExtension = FileDocumentManager.getInstance()
                .getFile(document)
                .getExtension();
    
        if (fileExtension == null) {
            return;
        }
    
        // PsiJavaCodeReferenceElement:Language
        // PsiReferenceExpression:Language
        Language language = Language.getLanguageByExtension(fileExtension);
        
        // TODO: make sure to order them by the IDE's import settings
        // PsiJavaCodeReferenceElement:List<String>
        // PsiJavaCodeReferenceElement:ArrayList<>
        List<String> imports = new ArrayList<>();
        
        if (language != null) {
            switch (language) {
                // PsiReferenceExpression:JAVA
                case JAVA:
                
            }
        } else {
            return;
        }
        
//        switch (fileExtension) {
//            case "java": // Java
//                // get available libraries & filter classes via Library
//                // editor.getDocument().insertString();
//                // search document.getText() [perhaps with a range] to find the last line starting with import. create a new line after it and add the new import.
//                break;
//        }
        
        // TODO: convert this to a list of popups and display them one after another
        //       alternatively have one paginated popup
        List<String> importOptions = Arrays.asList("test", "test2", "test3");
        
        JBPopup popup = JBPopupFactory.getInstance()
            .createPopupChooserBuilder(importOptions)
            .setTitle(MyBundle.message("name"))
            .createPopup();
        
        popup.showInFocusCenter();
    }
}