package com.finalsprint.bstree.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.finalsprint.bstree.model.AVLTree;
import com.finalsprint.bstree.model.Submit;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

class MainControllerTest {
    @Test
    void testGetSubmitPage() {
        MainController mainController = new MainController();
        assertEquals("submit", mainController.getSubmitPage(new ConcurrentModel()));
    }

    @Test
    void testSubmitForm() throws JSONException {
        MainController mainController = new MainController();

        Submit submit = new Submit();
        submit.setNumber5(10);
        submit.setNumber6(10);
        submit.setNumber3(10);
        submit.setNumber4(10);
        submit.setNumber9(10);
        submit.setNumber7(10);
        submit.setNumber8(10);
        submit.setNumber1(10);
        submit.setNumber2(10);
        submit.setNumber10(10);
        ConcurrentModel model = new ConcurrentModel();
        AVLTree avlTree = mock(AVLTree.class);
        doNothing().when(avlTree).insert(anyInt());
        JSONObject toJSONObjectResult = HTTP.toJSONObject("https://example.org/example");
        assertEquals("results", mainController.submitForm(submit, model, avlTree, toJSONObjectResult));
        verify(avlTree, atLeast(1)).insert(anyInt());
        assertEquals(4, toJSONObjectResult.length());
    }

    @Test
    void testSubmitForm2() throws JSONException {
        MainController mainController = new MainController();

        Submit submit = new Submit();
        submit.setNumber5(10);
        submit.setNumber6(10);
        submit.setNumber3(10);
        submit.setNumber4(10);
        submit.setNumber9(10);
        submit.setNumber7(10);
        submit.setNumber8(10);
        submit.setNumber1(10);
        submit.setNumber2(10);
        submit.setNumber10(10);
        ConcurrentModel model = new ConcurrentModel();
        AVLTree avlTree = mock(AVLTree.class);
        doNothing().when(avlTree).insert(anyInt());
        JSONObject jsonObject = mock(JSONObject.class);
        when(jsonObject.put((String) any(), (Object) any())).thenReturn(HTTP.toJSONObject("https://example.org/example"));
        assertEquals("results", mainController.submitForm(submit, model, avlTree, jsonObject));
        verify(avlTree, atLeast(1)).insert(anyInt());
        verify(jsonObject).put((String) any(), (Object) any());
    }
}

