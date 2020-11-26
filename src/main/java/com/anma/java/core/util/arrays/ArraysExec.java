package com.anma.java.core.util.arrays;

import java.util.Arrays;

public class ArraysExec {

    public static void main(String[] args) {

        int[] arr1 = new int[4];
        int[] arr2 = {1, 2, 3, 4, 5};
        String[] arr3 = new String[] {"Hello", "Petro"};

        Arrays.fill(arr1, 4);
//        System.out.println(Arrays.toString(arr1));

        int result = Arrays.binarySearch(arr1, 4);
        System.out.println(result);

        String pagesWithSemis = "CR-BRIDGE-8826 Change of UUI Generation rule for Kaltura and AAA Ldap;" +
                "CR-BRIDGE-8577 Unifying notifications through Ni-Fi;" +
                "CR-BRIDGE-8568 Derive Bill Delivery Method from Bill Style during account creation;" +
                "CR-BRIDGE-8543 Mismatch of naming convention of RBM DWH feeds;" +
                "CR-BRIDGE-8504 [Cross-Stream] Bulk Operations - Bulk Adjustments;" +
                "CR-BRIDGE-8474 Changes to Kaltura Ids management;" +
                "CR-BRIDGE-8400 Email notification about ticket creation;" +
                "CR-BRIDGE-8398 Wrapping long payment method description;" +
                "CR-BRIDGE-8387 Notification template modification;" +
                "CR-BRIDGE-8384 Collections suspend for Kaltura;" +
                "CR-BRIDGE-8357 Change Request: do not summarize unit price in the invoice;" +
                "CR-BRIDGE-8301 Approval Threshold for the Business Roles;" +
                "CR-BRIDGE-8284 NC Payment page Privacy requirements;" +
                "CR-BRIDGE-8230 Expiration period for Individual Authentication session;" +
                "CR-BRIDGE-8179 Copy Bills feature to be disable from CBM;" +
                "CR-BRIDGE-8121 Security Gateway SUB field / domain value;" +
                "CR-BRIDGE-10185 Subscription ID change on Kaltura Preprod;" +
                "CR-BRIDGE-10062 FMC flag on Customer Account to be included into RDB extract;";
        String[] strArray = pagesWithSemis.split(";");
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }

    }
}
