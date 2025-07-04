<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '공급계획' }" />
        <VerticalNavLink
            :item="{
                title: '주택사업',
                to: '/housingProjects',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '주택공급',
                to: '/houseSupplies',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '청약공지/접수' }" />
        <VerticalNavLink
            :item="{
                title: '모집공고',
                to: '/announcements',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '청약접수',
                to: '/subscriptions',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '모집공고 목록',
                to: '/getAnnouncements',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '알림' }" />
        <VerticalNavLink
            :item="{
                title: '신청결과알림',
                to: '/notifications',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '청약당첨자' }" />
        <VerticalNavLink
            :item="{
                title: '당첨자',
                to: '/winners',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '청약당첨자 목록',
                to: '/winningDashboards',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '입주/퇴거/입주관리' }" />
        <VerticalNavLink
            :item="{
                title: '입주정보',
                to: '/tenants',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '유지보수',
                to: '/maintenances',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '계약정보' }" />
        <VerticalNavLink
            :item="{
                title: '계약정보',
                to: '/contracts',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '입주연장계약',
                to: '/extendContracts',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '계약체결이력',
                to: '/contractDashboards',
            }"
        />
    </ul>
</template>
