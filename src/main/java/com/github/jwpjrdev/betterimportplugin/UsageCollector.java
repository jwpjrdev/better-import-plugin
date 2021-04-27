package com.github.jwpjrdev.betterimportplugin;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaRecursiveElementVisitor;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiJavaFile;

// TODO: handle static imports
// TODO: handle wildcard imports
public class UsageCollector { // check if it has starts with "class " or "@interface ", etc.
    
    // identifier list, identifier string
    // params: PsiJavaToken:LPARENTH to start, PsiJavaToken:RPARENTH to end searching
    //         PsiJavaCodeReferenceElement:Project followed by PsiReferenceParameterList. the variable name is also an identifier so be careful
    public List<String> collectUsages(Project project, Document document, Language language) {
        final List<String> imports = new ArrayList<>();
        
        // ignore
        switch (language) {
            case JAVA:
                final PsiJavaFile psiFile = (PsiJavaFile) PsiDocumentManager.getInstance(project).getPsiFile(document);
    
                psiFile.accept(new JavaRecursiveElementVisitor() {
                    @Override
                    public void visitElement(@NotNull PsiElement element) {
                        // if (element.)
                        psiFile.getImportList();
                    }
                });
                break;
            default:
                return new ArrayList<>();
        }
        
        return imports;
    }
}
